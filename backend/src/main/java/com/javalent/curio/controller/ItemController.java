package com.javalent.curio.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.models.Item;
import com.javalent.curio.models.Tag;
import com.javalent.curio.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemRepository items;

    @GetMapping("/items")
    public List<Item> getItems(@RequestParam("tags") Optional<List<String>> tags) {
        if (tags.isPresent()) {
            return items.findByTagsIn(tags.get().stream().map(tag -> new Tag(tag)).collect(Collectors.toList()));
        }
        return items.findAll();
    }

    @GetMapping("/items/{item}")
    public Optional<Item> getItem(@PathVariable("item") String item) {
        return items.findById(item);
    }

}
