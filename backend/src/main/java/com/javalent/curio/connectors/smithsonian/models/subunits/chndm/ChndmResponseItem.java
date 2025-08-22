package com.javalent.curio.connectors.smithsonian.models.subunits.chndm;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.javalent.curio.connectors.smithsonian.models.SmithsonianResponseItem;

import generated.schemas.edan.DescriptiveNonRepeating;
import generated.schemas.edan.Freetext;
import generated.schemas.edan.FreetextProperty;
import jakarta.annotation.PostConstruct;

@JsonTypeName("unitCode")
public class ChndmResponseItem extends SmithsonianResponseItem {
    private static final Logger LOGGER = Logger.getLogger(ChndmResponseItem.class);

    @PostConstruct
    void init() {

    }

    @Override
    public String getTitle() {
        Freetext freetext = this.getContent().getFreetext();
        String objectName = null;
        String title = null;
        String date = null;

        for (List<FreetextProperty> fPropList : freetext.getAdditionalProperties().values()) {
            for (FreetextProperty fProp : fPropList) {
                if (fProp.getLabel().equals("Object Name")) {
                    objectName = fProp.getContent();
                }
                if (fProp.getLabel().equals("Date")) {
                    date = fProp.getContent();
                }
            }
        }
        DescriptiveNonRepeating dnr = getContent().getDescriptiveNonRepeating();
        if (dnr != null && dnr.getTitle() != null) {
            title = dnr.getTitle().getContent();
        }
        if ((title == null || title.isEmpty()) && (objectName == null || objectName.isEmpty())
                && (date == null || date.isEmpty())) {
            return "No title";
        }

        List<String> parts = new ArrayList<>();
        if (objectName != null && !objectName.isEmpty())
            parts.add(objectName);
        if (title != null && !title.isEmpty())
            parts.add(title);
        if (date != null && !date.isEmpty())
            parts.add(date);

        return String.join(", ", parts);
    }

}
