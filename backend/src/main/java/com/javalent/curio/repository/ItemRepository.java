package com.javalent.curio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalent.curio.models.Item;
import com.javalent.curio.models.Tag;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findByTagsIn(List<Tag> tags);
}
