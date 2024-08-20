package com.javalent.curio.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.NaturalId;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @Nonnull
    @NaturalId
    @ColumnTransformer(write = "LOWER(?)")
    public String id;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
    public Set<Item> items = new HashSet<>();

    public Set<Item> getItems() {
        return items;
    }

    public Tag(String tag) {
        this.id = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tag tag = (Tag) o;
        return Objects.equals(this.id, tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
