package com.javalent.curio.items.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.javalent.curio.items.models.Item;
import com.javalent.curio.items.models.ItemDTO;
import com.javalent.curio.items.repository.ItemRepository;
import com.javalent.curio.search.SearchPredicate;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> getAll() {
        return itemRepository.findAll(Sort.by("title"));
    }

    public Iterable<Item> getAll(ItemDTO params) {
        return getAll(params, Pageable.ofSize(100));
    }

    public Iterable<Item> getAll(ItemDTO params, @PageableDefault(value = 100) Pageable page) {
        System.out.println("GET ITEMS");
        if (!params.getTags().isEmpty() && !params.getMuseums().isEmpty()) {
            return itemRepository.findByTagsInAndMuseum_NameIn(params.getTags(), params.getMuseums(),
                    page);
        }
        if (!params.getTags().isEmpty()) {
            return itemRepository.findByTagsIn(params.getTags(), page);
        }
        if (!params.getMuseums().isEmpty()) {
            return itemRepository.findByMuseum_NameIn(params.getMuseums(), page);
        }

        return itemRepository.findAll(page);
    }

    public Optional<Item> getOne(String item) {
        return itemRepository.findById(item);
    }

    List<SearchPredicate> predicates = Arrays.asList(
            SearchPredicate.builder().field("title").boost(1000).build(),
            SearchPredicate.builder().field("title").boost(500).fuzzy(2).build(),
            SearchPredicate.builder().field("summary").field("physicalDescription").field("longDescription").boost(100)
                    .fuzzy(1).build());

    public List<Item> search(String query) {
        return itemRepository.searchBy(predicates, query, 100);
    }

    public void delete() {
        itemRepository.deleteAll();
    }

}
