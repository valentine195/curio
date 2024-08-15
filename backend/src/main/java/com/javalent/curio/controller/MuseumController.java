package com.javalent.curio.controller;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.models.Museum;
import com.javalent.curio.repository.MuseumRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MuseumController {
    @Autowired
    private MuseumRepository museums;

    @GetMapping("/museums")
    public List<Museum> getMethodName() {
        return museums.findAll();
    }
    
}
