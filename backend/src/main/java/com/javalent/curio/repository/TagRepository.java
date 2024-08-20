package com.javalent.curio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalent.curio.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
}
