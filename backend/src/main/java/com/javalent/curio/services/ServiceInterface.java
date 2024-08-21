package com.javalent.curio.services;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {
    List<T> getAll();
    Optional<T> getOne(String item);
}
