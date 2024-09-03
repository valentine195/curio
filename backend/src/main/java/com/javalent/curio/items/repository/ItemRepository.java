package com.javalent.curio.items.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.javalent.curio.items.models.Item;
import com.javalent.curio.search.SearchRepository;

@Repository
public interface ItemRepository
        extends SearchRepository<Item, String>, CrudRepository<Item, String> {

    @NonNull
    Optional<Item> findById(@NonNull String id);

    Page<Item> findByMuseum_NameIn(List<String> museum, Pageable pageable);

    Page<Item> findByTagsIn(List<String> tags, Pageable pageable);

    Page<Item> findByTagsInAndMuseum_NameIn(List<String> tags, List<String> museums, Pageable pageable);
}