package com.javalent.curio.models;

import java.util.UUID;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue
    public UUID id;

    @Nonnull
    public UUID museum;
    
    @Nonnull
    public String title;

    public String subUnit;

    public String thumbnail;

    public String description;
}
