package com.javalent.curio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javalent.curio.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
    @Query("select tag.id from Tag tag")
    List<String> findTagNames();
}
