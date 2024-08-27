package com.javalent.curio.museums.smithstonian;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.javalent.curio.models.Item;
import com.javalent.curio.models.Museum;
import com.javalent.curio.repository.items.ItemRepository;

@Service
public class Downloader {
    @Value("${smithstonian.download}")
    private Boolean SHOULD_DOWNLOAD;

    // https://www.baeldung.com/spring-inject-arrays-lists#injecting-lists
    @Value("#{'${smithstonian.subunits}'.toLowerCase().split(',')}")
    private List<String> SUB_UNITS;

    private static String BASE_URL = "https://smithsonian-open-access.s3-us-west-2.amazonaws.com/metadata/edan";
    private static String INDEX_FILE = "/index.txt";

    @Autowired
    private ItemRepository itemRepository;

    ExecutorService pool = Executors.newCachedThreadPool();

    Museum smithstonian;

    @EventListener(ApplicationReadyEvent.class)
    public void downloadFiles() {
        if (!SHOULD_DOWNLOAD)
            return;

        System.out.println("sub_units: " + SUB_UNITS);
        List<String> mainIndices = downloadFile(BASE_URL + INDEX_FILE);

        for (String index : mainIndices) {
            var sub_unit = index.substring(BASE_URL.length() + 1, index.indexOf(INDEX_FILE));
            if (SUB_UNITS.contains(sub_unit)) {
                pool.execute(new DeserializeAndInsertTask(downloadFile(index), sub_unit));
            }
        }

    }

    public List<String> downloadFile(String URL) {

        var main = pool.submit(new DownloadTask(URL));

        try {
            return main.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("There was an issue downloading the Smithstonian data.");
        return new ArrayList<String>();
    }

    class DeserializeAndInsertTask implements Runnable {

        private List<String> indices;
        private String sub_unit;

        public DeserializeAndInsertTask(List<String> indices, String sub_unit) {
            this.indices = indices;
            this.sub_unit = sub_unit;
        }

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false).registerModule(new Jdk8Module());

        @Override
        public void run() {
            int added = 0;
            for (String index : indices) {
                List<String> jsons = downloadFile(index);
                for (String json : jsons) {
                    try {
                        SmithstonianItem smithstonianItem = mapper.readValue(json, SmithstonianItem.class);
                        Item item = new Item(smithstonianItem);
                        itemRepository.save(item);
                        added++;
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Added " + added + " items for sub unit " + sub_unit);
        }

    }

    static class DownloadTask implements Callable<List<String>> {

        private String url;

        public DownloadTask(String url) {
            this.url = url;
        }

        @Override
        public List<String> call() throws Exception {
            Scanner s = new Scanner(new URI(url).toURL().openStream(), "UTF-8").useDelimiter("\\n");
            List<String> str = new ArrayList<String>();
            while (s.hasNext()) {
                str.add(s.next());
            }
            s.close();
            return str;
        }
    }
}
