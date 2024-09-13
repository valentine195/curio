package com.javalent.curio.features.tags.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.features.tags.services.TagService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    
    private final TagService tagService;

    @GetMapping
    public List<String> getItems() {
        return tagService.getTags();
    }

    @DeleteMapping
    public void deleteAllItems() {
        tagService.delete();
    }

}
