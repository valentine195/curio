package com.javalent.curio.tags.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.tags.services.TagService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public List<String> getItems() {
        return tagService.getTags();
    }

}
