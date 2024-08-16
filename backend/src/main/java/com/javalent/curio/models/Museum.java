package com.javalent.curio.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "museums")
public class Museum {

    @Id
    @GeneratedValue
    public UUID id;

    public String name;

    public Museum(String name) {
        this.name = name;
    }
    public Museum() {}
}
