package com.javalent.curio.features.items.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import generated.schemas.edan.OnlineMedia;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import com.javalent.curio.connectors.smithsonian.models.SmithsonianResponseItem;
import com.javalent.curio.features.museums.models.Museum;
import com.javalent.curio.features.museums.models.Museum.BaseMuseum;
import com.javalent.curio.features.tags.models.Tag;

import generated.schemas.edan.FreetextProperty;
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
    @IndexedEmbedded(structure = ObjectStructure.NESTED)
    private Museum museum;

    public BaseMuseum getMuseum() {
        return museum.getBase();
    }

    @Nonnull
    @FullTextField
    public String title;

    public String thumbnail;

    @FullTextField
    public String summary;
    @FullTextField
    public String physicalDescription;
    @FullTextField
    @Column(name = "long_description")
    public String longDescription;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
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

    public Item(SmithsonianResponseItem smithsonianItem) {
        this.id = smithsonianItem.getId();
        this.title = smithsonianItem.getTitle();
        var unitCode = smithsonianItem.getUnitCode();
        this.museum = new Museum(unitCode.toString(), "Smithsonian Institute");

        if (smithsonianItem.getContent().getDescriptiveNonRepeating() != null) {
            OnlineMedia onlineMedia = smithsonianItem.getContent().getDescriptiveNonRepeating().getOnlineMedia();
            if (onlineMedia != null
                    && onlineMedia.getMedia() != null && !onlineMedia.getMedia().isEmpty()) {
                this.thumbnail = "https://ids.si.edu/ids/deliveryService?id=" + onlineMedia.getMedia()
                        .getFirst().getIdsId();
            }
        }

        if (smithsonianItem.getContent().getFreetext().getAdditionalProperties().containsKey("notes")) {
            for (FreetextProperty note : smithsonianItem.getContent().getFreetext().getAdditionalProperties().get("notes")) {
                switch (note.getLabel()) {
                    case "Long Description": {
                        if (this.longDescription == null) {
                            this.longDescription = "";
                        }
                        this.longDescription += note.getContent() + "\n\n";
                        break;
                    }
                    case "Physical Description": {
                        if (this.physicalDescription == null) {
                            this.physicalDescription = "";
                        }
                        this.physicalDescription += note.getContent() + "\n\n";
                        break;
                    }
                    case "Summary": {
                        if (this.summary == null) {
                            this.summary = "";
                        }
                        this.summary += note.getContent() + "\n\n";
                        break;
                    }
                }
            }
        }

        if (smithsonianItem.getContent().getIndexedStructured() != null
                && smithsonianItem.getContent().getIndexedStructured().getObjectType() != null) {
            for (String tag : smithsonianItem.getContent().getIndexedStructured().getObjectType()) {
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
