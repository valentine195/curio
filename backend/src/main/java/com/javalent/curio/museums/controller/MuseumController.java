package com.javalent.curio.museums.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.museums.services.MuseumService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/museums")
public class MuseumController {
    @Autowired
    private MuseumService museums;

    @GetMapping
    public List<String> getMuseumNames() {
        return museums.getMuseums();
    }

    @DeleteMapping
    public void deleteAllItems() {
        museums.delete();
    }

}
