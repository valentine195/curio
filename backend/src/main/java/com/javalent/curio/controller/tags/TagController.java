package com.javalent.curio.controller.tags;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.models.Tag;
import com.javalent.curio.services.TagService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
