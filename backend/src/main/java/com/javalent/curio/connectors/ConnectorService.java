package com.javalent.curio.connectors;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javalent.curio.connectors.models.response.ResponseItem;
import com.javalent.curio.features.items.models.Item;

@Service
public class ConnectorService {
    private final Map<String, Connector<?>> MAP = new HashMap<>();

    public void register(String institution, Connector<?> connector) {
        MAP.put(institution, connector);
    }

    public Optional<? extends ResponseItem> getItem(Item item) {
        Connector<?> connector = MAP.get(item.getMuseum().institution);
        if (connector == null)
            return Optional.empty();

        Optional<? extends ResponseItem> response = connector.getItem(item.id);

        return response;
    }
}
