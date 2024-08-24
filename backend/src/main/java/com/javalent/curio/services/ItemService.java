package com.javalent.curio.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.javalent.curio.controller.items.ItemDTO;
import com.javalent.curio.models.Item;
import com.javalent.curio.repository.ItemRepository;

@Service
public class ItemService /* implements ServiceInterface<Item> */ {

    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> getAll() {
        return itemRepository.findAll(Sort.by("title"));
    }

    /*
     * public List<Item> getAllPaginated(ItemDTO params, Pageable page) {
     * 
     * }
     */

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

}
