package com.javalent.curio.models;

import java.util.UUID;

import com.javalent.curio.museums.smithstonian.SmithstonianItem;
import com.javalent.curio.museums.smithstonian.SmithstonianItem.Note;
import com.javalent.curio.museums.smithstonian.SmithstonianItem.PhysicalDescription;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    public String id;

    @Nonnull
    private UUID museum;

    @Nonnull
    public String title;

    public String subUnit;

    public String thumbnail;

    public String description;

    public Item(SmithstonianItem smithstonianItem, Museum museum) {
        this.id = smithstonianItem.id;
        this.title = smithstonianItem.title;
        this.subUnit = smithstonianItem.unitCode;
        this.museum = museum.id;
        if (smithstonianItem.content.descriptiveNonRepeating.online_media != null
                && smithstonianItem.content.descriptiveNonRepeating.online_media.media != null) {
            this.thumbnail = smithstonianItem.content.descriptiveNonRepeating.online_media.media
                    .get(0).thumbnail;
        }

        if (smithstonianItem.content.freetext.notes != null) {
            for (Note desc : smithstonianItem.content.freetext.notes) {
                if (desc.label.equals("Physical Description")) {
                    this.description = desc.content;
                    break;
                }
            }

        }

    }

    public Item() {
    }
}
