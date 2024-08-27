package com.javalent.curio.tags.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalent.curio.tags.repository.TagRepository;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public List<String> getTags() {
        return tagRepository.findTagNames();
    }

}