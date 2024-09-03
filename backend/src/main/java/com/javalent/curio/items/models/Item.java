package com.javalent.curio.items.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import com.javalent.curio.connectors.smithstonian.models.SmithstonianItem;
import com.javalent.curio.museums.models.Museum;
import com.javalent.curio.museums.models.Museum.BaseMuseum;
import com.javalent.curio.tags.models.Tag;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Indexed
@ToString
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
    @FullTextField
    public String title;

    public String thumbnail;
/*     @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Media> media = new ArrayList<>();

    public void setMedia(List<Media> list) {
        for (Media media : list) {
            media.setItem(this);
        }
        this.media = list;
    } */

    @FullTextField
    public String summary;
    @FullTextField
    public String physicalDescription;
    @FullTextField
    @Column(name = "long_description")
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

/*         List<Media> mediaList = new ArrayList<>();
        if (smithstonianItem.content.descriptiveNonRepeating.online_media != null
                && smithstonianItem.content.descriptiveNonRepeating.online_media.media != null) {
            for (SmithstonianItem.Medium medium : smithstonianItem.content.descriptiveNonRepeating.online_media.media) {
                if (medium.resources != null) {
                    for (SmithstonianItem.Resource resource : medium.resources) {
                        if (resource.label == null) continue;
                        Media m = new Media(resource.url, resource.label);
                        mediaList.add(m);
                        System.out.println(m);
                    }
                }
            }
        }
        this.setMedia(mediaList);
        System.out.println(this.getMedia()); */

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
