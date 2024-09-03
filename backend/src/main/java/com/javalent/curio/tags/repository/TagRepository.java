package com.javalent.curio.tags.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javalent.curio.search.SearchRepository;
import com.javalent.curio.tags.models.Tag;

@Repository
public interface TagRepository extends SearchRepository<Tag, String>, JpaRepository<Tag, String> {
    @Query("select tag.id from Tag tag")
    List<String> findTagNames();
}
