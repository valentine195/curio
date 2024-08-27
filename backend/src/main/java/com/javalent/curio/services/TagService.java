package com.javalent.curio.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalent.curio.repository.TagRepository;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public List<String> getTags() {
        return tagRepository.findTagNames();
    }

}