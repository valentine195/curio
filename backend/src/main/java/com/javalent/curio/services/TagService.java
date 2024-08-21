package com.javalent.curio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalent.curio.models.Tag;
import com.javalent.curio.repository.TagRepository;

@Service
public class TagService implements ServiceInterface<Tag> {

    @Autowired
    TagRepository tagRepository;

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public List<String> getTags() {
        return tagRepository.findTagNames();
    }

    public Optional<Tag> getOne(String tag) {
        return tagRepository.findById(tag);
    }

}