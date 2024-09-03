package com.javalent.curio.connectors.smithstonian.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javalent.curio.connectors.ResponseItem;

import lombok.ToString;

@ToString
public class SmithstonianItem implements ResponseItem {
    public String id;
    public String version;
    public UnitCode unitCode;
    public String linkedId;
    public String type;
    public Content content;
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

    public static class Content {
        public DescriptiveNonRepeating descriptiveNonRepeating;
        public IndexedStructured indexedStructured;
        public Freetext freetext;
    }

    public static class Freetext {
        public ArrayList<TextContent> setName;
        public ArrayList<TextContent> identifier;
        public ArrayList<Note> notes;
        public ArrayList<TextContent> creditLine;
        public ArrayList<TextContent> name;
        public ArrayList<TextContent> place;
        public ArrayList<PhysicalDescription> physicalDescription;
        public ArrayList<TextContent> dataSource;
        public ArrayList<TextContent> objectRights;
        public ArrayList<TextContent> objectType;
    }

    public static class Note {
        public String label;
        public String content;
    }

    public static class PhysicalDescription {
        public String label;
        public String content;
    }

    public static class DescriptiveNonRepeating {
        public String record_ID;
        public OnlineMedia online_media;
        public String unit_code;
        public String title_sort;
        public String guid;
        public String record_link;
        public TextContent title;
        public Usage metadata_usage;
        public String data_source;
    }

    public static class OnlineMedia {
        public int mediaCount;
        public ArrayList<Medium> media;
    }

    public static class Medium {
        public String thumbnail;
        public String idsId;
        public Usage usage;
        public String guid;
        public String type;
        public String content;
        public ArrayList<Resource> resources;
    }

    public static class TextContent {
        public String label;
        public String content;
    }

    public static class GeoLocation {
        @JsonProperty("L2")
        public TextContent l2;
    }

    public static class IndexedStructured {
        public ArrayList<GeoLocation> geoLocation;
        public ArrayList<String> object_type;
        public ArrayList<String> name;
        public ArrayList<String> place;
        public ArrayList<String> usage_flag;
        public ArrayList<String> online_media_type;
    }

    public static class Resource {
        public int width;
        public int height;
        public String label;
        public String url;
        public String dimensions;
    }

    public static class Usage {
        public String access;
    }
}
