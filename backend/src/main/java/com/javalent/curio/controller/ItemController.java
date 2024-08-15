package com.javalent.curio.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.models.Item;
import com.javalent.curio.repository.ItemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemRepository items;

    @GetMapping("/items")
    public List<Item> getItems() {
        return items.findAll();
    }

    @PostMapping("/items")
    public void postMethodName(@RequestBody List<Item> items) {

    }

}
