package com.javalent.curio.features.tags.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javalent.curio.features.tags.models.Tag;
import com.javalent.curio.search.SearchRepository;

@Repository
public interface TagRepository extends SearchRepository<Tag, String>, JpaRepository<Tag, String> {
    @Query("select tag.id from Tag tag")
    List<String> findTagNames();
}
