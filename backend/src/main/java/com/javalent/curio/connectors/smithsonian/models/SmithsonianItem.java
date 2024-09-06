package com.javalent.curio.connectors.smithsonian.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javalent.curio.connectors.ResponseItem;

import generated.javalent.curio.schemas.edan.Edanmdm;
import lombok.ToString;

@ToString
public class SmithsonianItem implements ResponseItem {
    public String id;
    public String version;
    public UnitCode unitCode;
    public String linkedId;
    public String type;
    public Edanmdm content;
    public String url;
    public String hash;
    public String docSignature;
    public int timestamp;
    public int lastTimeUpdated;
    public String title;

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

        private final String name;

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
