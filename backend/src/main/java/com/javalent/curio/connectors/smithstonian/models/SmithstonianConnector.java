package com.javalent.curio.connectors.smithstonian.models;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.javalent.curio.connectors.Connector;
import com.javalent.curio.connectors.ConnectorService;
import com.javalent.curio.connectors.smithstonian.SmithstonianResponse;

import jakarta.annotation.PostConstruct;

@Service
public class SmithstonianConnector implements Connector<SmithstonianItem> {

    @Autowired
    ConnectorService SERVICE;

    @PostConstruct
    public void init() {
        SERVICE.register("Smithstonian Institute", this);
        System.out.println("API KEY: " + API_KEY);
    }

    RestClient defaultClient = RestClient.create();

    @Value("${smithstonian.apikey}")
    private String API_KEY;

    String url = "https://api.si.edu/openaccess/api/v1.0/content/";

    @Override
    public SmithstonianItem getItem(String id) {
        System.out.println("Running Smithstonian connector for id: " + id);
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.si.edu/openaccess/api/v1.0/content/{item}?api_key={key}")
                .build(id, API_KEY);
        System.out.println(uri);
        var response = defaultClient.get()
                .uri(uri).retrieve()
                .body(SmithstonianResponse.class);

        return response.response;

    }

}
