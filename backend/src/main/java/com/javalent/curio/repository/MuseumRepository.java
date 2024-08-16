package com.javalent.curio.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalent.curio.models.Museum;

@Repository
public interface MuseumRepository extends JpaRepository<Museum, UUID> {
    public Optional<Museum> findByName(String name);
}
