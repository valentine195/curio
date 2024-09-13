package com.javalent.curio.connectors;

import com.javalent.curio.connectors.models.response.ResponseItem;

import java.util.Optional;

public interface Connector<T extends ResponseItem> {
    public Optional<T> getItem(String id);
}
