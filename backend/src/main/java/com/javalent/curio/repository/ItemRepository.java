package com.javalent.curio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalent.curio.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
