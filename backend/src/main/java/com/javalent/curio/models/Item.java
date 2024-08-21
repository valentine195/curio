package com.javalent.curio.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.javalent.curio.models.Museum.BaseMuseum;
import com.javalent.curio.museums.smithstonian.SmithstonianItem;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "items")
public class Item {

    @Id
    public String id;

    public String getId() {
        return id;
    }

    @Nonnull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "museum")
    private Museum museum;

    public BaseMuseum getMuseum() {
        return museum.getBase();
    }

    @Nonnull
    public String title;


    public String thumbnail;

    public String summary;
    public String physicalDescription;
    public String longDescription;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(name = "ITEMS_TAGS")
    private List<Tag> tags = new ArrayList<>();

    public List<String> getTags() {
        return tags.stream().map(t -> t.id).collect(Collectors.toList());
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getItems().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getItems().remove(this);
    }

    public Item(SmithstonianItem smithstonianItem) {
        this.id = smithstonianItem.id;
        this.title = smithstonianItem.title;
        this.museum = new Museum(smithstonianItem.unitCode.toString(), "Smithstonian Institute");

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
                this.addTag(new Tag(tag));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Item))
            return false;
        return id != null && id.equals(((Item) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
