package com.javalent.curio.controller.museums;

import org.springframework.web.bind.annotation.RestController;

import com.javalent.curio.services.MuseumService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class MuseumController {
    @Autowired
    private MuseumService museums;

    @GetMapping("/museums")
    public List<String> getMuseumNames() {
        return museums.getMuseums();
    }

}
