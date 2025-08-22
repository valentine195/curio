package com.javalent.curio.connectors.smithsonian.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.javalent.curio.connectors.models.response.ResponseItem;
import com.javalent.curio.connectors.models.response.ResponseItemImage;

import com.javalent.curio.connectors.smithsonian.models.subunits.DefaultSmithsonianResponseItem;
import com.javalent.curio.connectors.smithsonian.models.subunits.chndm.ChndmResponseItem;
import com.javalent.curio.connectors.smithsonian.models.subunits.nasm.NasmResponseItem;

import generated.schemas.edan.Medium;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "unitCode",
        visible = true,
        defaultImpl = DefaultSmithsonianResponseItem.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NasmResponseItem.class, name = "NASM"),
        @JsonSubTypes.Type(value = ChndmResponseItem.class, name = "CHNDM")
})
public abstract class SmithsonianResponseItem extends ResponseItem {

    @JsonProperty("unitCode")
    public UnitCode unitCode;

    private SmithsonianEdanmdmContent content;

    @Override
    public List<ResponseItemImage> getImages() {
        List<ResponseItemImage> list = new ArrayList<>();

        for (Medium media : this.getContent().getDescriptiveNonRepeating().getOnlineMedia().getMedia()) {
            String url = "https://ids.si.edu/ids/deliveryService?id=" + media.getIdsId();
            list.add(new ResponseItemImage(url, url + "&max_w=250"));
        }

        return list;
    }

    @Override
    public String getUrl() {
        return this.getContent().getDescriptiveNonRepeating().getRecordLink();
    }

    @Getter
    public enum UnitCode {
        AAA("Archives of American Art"),
        ACM("Anacostia Community Museum"),
        CFCHFOLKLIFE("Ralph Rinzler Folklife Archives and Collections"),
        CHNDM("Cooper Hewitt, Smithsonian Design Museum"),
        EEPA("Eliot Elisofon Photographic Archives"),
        FBR("Smithsonian Field Book Project"),
        FSG("Freer Gallery of Art and Arthur M. Sackler Gallery"),
        HAC("Smithsonian Gardens"),
        HMSG("Hirshhorn Museum and Sculpture Garden"),
        HSFA("Human Studies Film Archives"),
        NAA("National Anthropological Archives"),
        NASM("National Air and Space Museum"),
        NMAAHC("National Museum of African American History and Culture"),
        NMAH("National Museum of American History"),
        NMAI("National Museum of the American Indian"),
        NMAfA("National Museum of African Art"),
        NMNH("National Museum of Natural History"),
        NMNHANTHRO("NMNH - Anthropology Dept."),
        NMNHBIRDS("NMNH - Vertebrate Zoology - Birds Division"),
        NMNHBOTANY("NMNH - Botany Dept."),
        NMNHEDUCATION("NMNH - Education & Outreach"),
        NMNHENTO("NMNH - Entomology Dept."),
        NMNHFISHES("NMNH - Vertebrate Zoology - Fishes Division"),
        NMNHHERPS("NMNH - Vertebrate Zoology - Herpetology Division"),
        NMNHINV("NMNH - Invertebrate Zoology Dept."),
        NMNHMAMMALS("NMNH - Vertebrate Zoology - Mammals Division"),
        NMNHMINSCI("NMNH - Mineral Sciences Dept."),
        NMNHPALEO("NMNH - Paleobiology Dept."),
        NPG("National Portrait Gallery"),
        NPM("National Postal Museum"),
        NZP("Smithsonian's National Zoo & Conservation Biology Institute"),
        SAAM("Smithsonian American Art Museum"),
        SIA("Smithsonian Institution Archives"),
        SIL("Smithsonian Libraries");

        @JsonCreator
        public static UnitCode forValue(String value) {
            for (UnitCode code : UnitCode.values()) {
                if (code.name().equalsIgnoreCase(value) || code.getName().equalsIgnoreCase(value)) {
                    return code;
                }
            }
            return null;
        }

        public final String name;

        private UnitCode(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }
    }

}
