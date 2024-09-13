package com.javalent.curio.features.tags.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.javalent.curio.features.tags.repository.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {

    
    private final TagRepository tagRepository;

    public List<String> getTags() {
        return tagRepository.findTagNames();
    }

    public void delete() {
        tagRepository.deleteAll();
    }

}