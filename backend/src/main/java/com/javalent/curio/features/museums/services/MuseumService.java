package com.javalent.curio.features.museums.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javalent.curio.features.museums.models.Museum;
import com.javalent.curio.features.museums.repository.MuseumRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MuseumService {
    private final MuseumRepository museumRepository;

    public List<String> getMuseums() {
        return this.museumRepository.findMuseumNames();
    }

    public Optional<Museum> getMuseum(String name) {
        return this.museumRepository.findByName(name);
    }

    public void delete() {
        museumRepository.deleteAll();
    }
}
