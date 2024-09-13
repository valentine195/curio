package com.javalent.curio.connectors.smithsonian.models;

import java.net.URI;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.javalent.curio.connectors.Connector;
import com.javalent.curio.connectors.ConnectorService;
import com.javalent.curio.connectors.smithsonian.SmithsonianResponse;
import com.javalent.curio.features.museums.models.Museum;
import com.javalent.curio.features.museums.services.MuseumService;

import jakarta.annotation.PostConstruct;

@Service
public class SmithsonianConnector implements Connector<SmithsonianResponseItem> {
    private static final Logger LOGGER = Logger.getLogger(SmithsonianConnector.class);
    private ConnectorService SERVICE;
    private MuseumService museumService;

    public SmithsonianConnector(ConnectorService SERVICE, MuseumService museumService) {
        this.SERVICE = SERVICE;
        this.museumService = museumService;
    }

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
    public Optional<SmithsonianResponseItem> getItem(String id) {
        System.out.println("Running Smithsonian connector for id: " + id);
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.si.edu/openaccess/api/v1.0/content/{item}?api_key={key}")
                .build(id, API_KEY);

        SmithsonianResponse response = defaultClient.get()
                .uri(uri).retrieve()
                .body(SmithsonianResponse.class);
        if (response == null) {
            return Optional.empty();
        }
        SmithsonianResponseItem item = response.getResponse();
        LOGGER.info(item.getUnitCode());

        System.out.println("MUSEUM CODE: " + item.getUnitCode().toString());
        Optional<Museum> museum = museumService.getMuseum(item.getUnitCode().toString());
        if (museum.isPresent()) {
            item.setMuseum(museum.get().getName());
            item.setInstitution(museum.get().getInstitution());
        }

        return Optional.of(item);

    }

}
