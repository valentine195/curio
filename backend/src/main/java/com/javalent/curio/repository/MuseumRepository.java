package com.javalent.curio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javalent.curio.models.Museum;

@Repository
public interface MuseumRepository extends JpaRepository<Museum, String> {
    public Optional<Museum> findByName(String name);

    @Query("select museum.name from Museum museum")
    List<String> findMuseumNames();
}
