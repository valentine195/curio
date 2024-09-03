package com.javalent.curio.connectors.smithsonian.models;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.javalent.curio.connectors.Connector;
import com.javalent.curio.connectors.ConnectorService;
import com.javalent.curio.connectors.smithsonian.SmithsonianResponse;

import jakarta.annotation.PostConstruct;

@Service
public class SmithsonianConnector implements Connector<SmithsonianItem> {

    @Autowired
    ConnectorService SERVICE;

    @PostConstruct
    public void init() {
        SERVICE.register("Smithsonian Institute", this);
        System.out.println("API KEY: " + API_KEY);
    }

    RestClient defaultClient = RestClient.create();

    @Value("${smithsonian.apikey}")
    private String API_KEY;

    String url = "https://api.si.edu/openaccess/api/v1.0/content/";

    @Override
    public SmithsonianItem getItem(String id) {
        System.out.println("Running Smithsonian connector for id: " + id);
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.si.edu/openaccess/api/v1.0/content/{item}?api_key={key}")
                .build(id, API_KEY);
        System.out.println(uri);
        var response = defaultClient.get()
                .uri(uri).retrieve()
                .body(SmithsonianResponse.class);

        return response.response;

    }

}
