package com.javalent.curio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalent.curio.repository.MuseumRepository;

@Service
public class MuseumService {
    @Autowired
    MuseumRepository museumRepository;

    public List<String> getMuseums() {
        return this.museumRepository.findMuseumNames();
    }
}
