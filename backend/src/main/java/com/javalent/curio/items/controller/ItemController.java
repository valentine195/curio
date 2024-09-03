package com.javalent.curio.items.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.connectors.ConnectorService;
import com.javalent.curio.items.models.Item;
import com.javalent.curio.items.models.ItemDTO;
import com.javalent.curio.items.services.ItemService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ConnectorService connectorService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public Iterable<Item> getItems(ItemDTO params, Pageable page) {
        return itemService.getAll(params, page);
    }

    @GetMapping("/{item}")
    public Optional<?> getItem(@PathVariable("item") String item) {
        Optional<Item> fromDB = itemService.getOne(item);
        if (!fromDB.isPresent())
            return fromDB;
        System.out.println("fromDB: " + fromDB.get());

        return connectorService.getItem(fromDB.get());

    }

    @GetMapping("/search")
    public List<Item> getMethodName(@RequestParam("query") String query) {
        return itemService.search(query);
    }

    @DeleteMapping
    public void deleteAllItems() {
        itemService.delete();
    }

}
