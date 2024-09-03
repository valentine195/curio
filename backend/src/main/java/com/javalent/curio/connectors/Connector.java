package com.javalent.curio.connectors;

public interface Connector<T extends ResponseItem> {
    public T getItem(String id);
}
