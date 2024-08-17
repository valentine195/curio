package com.javalent.curio.museums.smithstonian;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;



public class SmithstonianItem {
    public String id;
    public String version;
    public String unitCode;
    public String linkedId;
    public String type;
    public Content content;
    public String url;
    public String hash;
    public String docSignature;
    public int timestamp;
    public int lastTimeUpdated;
    public String title;

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
