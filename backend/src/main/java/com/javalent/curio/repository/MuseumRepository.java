package com.javalent.curio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javalent.curio.models.Museum;
import com.javalent.curio.repository.search.SearchRepository;

@Repository
public interface MuseumRepository extends SearchRepository<Museum, String> {
    public Optional<Museum> findByName(String name);

    @Query("select museum.name from Museum museum")
    List<String> findMuseumNames();
}
