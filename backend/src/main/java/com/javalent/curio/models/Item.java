package com.javalent.curio.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import com.javalent.curio.museums.smithstonian.SmithstonianItem;
import com.javalent.curio.museums.smithstonian.SmithstonianItem.Note;
import com.javalent.curio.museums.smithstonian.SmithstonianItem.PhysicalDescription;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    public String summary;
    public String physicalDescription;
    public String longDescription;

    public List<String> tags = new ArrayList<String>();

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
            for (SmithstonianItem.Note note : smithstonianItem.content.freetext.notes) {
                switch (note.label) {
                    case "Long Description": {
                        if (this.longDescription == null) {
                            this.longDescription = "";
                        }
                        this.longDescription += note.content + "\n\n";
                        break;
                    }
                    case "Physical Description": {
                        if (this.physicalDescription == null) {
                            this.physicalDescription = "";
                        }
                        this.physicalDescription += note.content + "\n\n";
                        break;
                    }
                    case "Summary": {
                        if (this.summary == null) {
                            this.summary = "";
                        }
                        this.summary += note.content + "\n\n";
                        break;
                    }
                }
            }
        }

        if (smithstonianItem.content.indexedStructured != null
                && smithstonianItem.content.indexedStructured.object_type != null) {
            for (String tag : smithstonianItem.content.indexedStructured.object_type) {
                this.tags.add(tag);
            }
        }
    }

    public Item() {
    }
}
