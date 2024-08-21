package com.javalent.curio.controller.items;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.models.Item;
import com.javalent.curio.services.ItemService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public Iterable<Item> getItems(ItemDTO params, Pageable page) {
        return itemService.getAll(params, page);
    }

    @GetMapping("/{item}")
    public Optional<Item> getItem(@PathVariable("item") String item) {
        return itemService.getOne(item);
    }

}
