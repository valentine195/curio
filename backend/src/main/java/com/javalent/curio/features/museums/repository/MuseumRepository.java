package com.javalent.curio.features.museums.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javalent.curio.features.museums.models.Museum;
import com.javalent.curio.search.SearchRepository;

@Repository
public interface MuseumRepository extends SearchRepository<Museum, String>, JpaRepository<Museum, String> {
    public Optional<Museum> findByName(String name);

    @Query("select museum.name from Museum museum")
    List<String> findMuseumNames();
}
