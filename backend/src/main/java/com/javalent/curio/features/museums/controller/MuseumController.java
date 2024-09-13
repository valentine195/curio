package com.javalent.curio.features.museums.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.features.museums.services.MuseumService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/museums")
@RequiredArgsConstructor
public class MuseumController {
    
    private final MuseumService museums;

    @GetMapping
    public List<String> getMuseumNames() {
        return museums.getMuseums();
    }

    @DeleteMapping
    public void deleteAllItems() {
        museums.delete();
    }

}
