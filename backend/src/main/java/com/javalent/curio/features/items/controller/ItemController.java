package com.javalent.curio.features.items.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.connectors.ConnectorService;
import com.javalent.curio.features.items.models.Item;
import com.javalent.curio.features.items.models.ItemSearchDTO;
import com.javalent.curio.features.items.services.ItemService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private static final Logger LOGGER = Logger.getLogger(ItemController.class);

    private final ConnectorService connectorService;
    private final ItemService itemService;

    @GetMapping
    public Page<Item> getItems(ItemSearchDTO params, @PageableDefault(value = 100, sort = { "title", "museum" }) Pageable page) {
        LOGGER.info(page);
        return itemService.getAll(params, page);
    }

    @GetMapping("/{item}")
    public Optional<?> getItem(@PathVariable("item") String item) {
        Optional<Item> fromDB = itemService.getOne(item);
        if (!fromDB.isPresent())
            return fromDB;

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
