package com.javalent.curio.museums.models;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.NaturalId;

import com.javalent.curio.items.models.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "museums")
public class Museum {

    @Data
    @AllArgsConstructor
    public class BaseMuseum {
        public String name;
        public String institution;
    }

    public BaseMuseum getBase() {
        return new BaseMuseum(name, institution);
    }

    @Id
    @NaturalId
    public String name;

    public String institution;

    @OneToMany(mappedBy = "museum")
    private Set<Item> items = new HashSet<>();

    public Museum(String name) {
        this.name = name;
    }

    public Museum(String name, String institution) {
        this.name = name;
        this.institution = institution;
    }
}
