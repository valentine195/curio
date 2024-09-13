package com.javalent.curio.connectors.smithsonian.nasm;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.javalent.curio.connectors.smithsonian.models.SmithsonianResponseItem;

import generated.schemas.edan.Freetext;
import generated.schemas.edan.FreetextProperty;
import jakarta.annotation.PostConstruct;

@JsonTypeName("unitCode")
public class NasmResponseItem extends SmithsonianResponseItem {
    private static final Logger LOGGER = Logger.getLogger(NasmResponseItem.class);

    @PostConstruct 
    void init() {
        
    }

    @Override
    public String getDescription() {
        Freetext freetext = this.getContent().getFreetext();
        List<String> summary = new ArrayList<>();

        for (List<FreetextProperty> fPropList : freetext.getAdditionalProperties().values()) {
            for (FreetextProperty fProp : fPropList) {
                if (fProp.getLabel().equals("Summary")) {
                    summary.add(fProp.getContent());
                }
            }
        }
        return String.join("\n\n", summary);
    }

}
