package com.javalent.curio.models.smithstonian;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

class Content {
    public DescriptiveNonRepeating descriptiveNonRepeating;
    public IndexedStructured indexedStructured;
    public Freetext freetext;
}

class CreditLine {
    public String label;
    public String content;
}

class DataSource {
    public String label;
    public String content;
}

class DescriptiveNonRepeating {
    public String record_ID;
    public OnlineMedia online_media;
    public String unit_code;
    public String title_sort;
    public String guid;
    public String record_link;
    public Title title;
    public MetadataUsage metadata_usage;
    public String data_source;
}

class Freetext {
    public ArrayList<SetName> setName;
    public ArrayList<Identifier> identifier;
    public ArrayList<Note> notes;
    public ArrayList<CreditLine> creditLine;
    public ArrayList<Name> name;
    public ArrayList<Place> place;
    public ArrayList<PhysicalDescription> physicalDescription;
    public ArrayList<DataSource> dataSource;
    public ArrayList<ObjectRight> objectRights;
    public ArrayList<ObjectType> objectType;
}

class GeoLocation {
    @JsonProperty("L2")
    public L2 l2;
}

class Identifier {
    public String label;
    public String content;
}

class IndexedStructured {
    public ArrayList<GeoLocation> geoLocation;
    public ArrayList<String> object_type;
    public ArrayList<String> name;
    public ArrayList<String> place;
    public ArrayList<String> usage_flag;
    public ArrayList<String> online_media_type;
}

class L2 {
    public String type;
    public String content;
}

class Medium {
    public String thumbnail;
    public String idsId;
    public Usage usage;
    public String guid;
    public String type;
    public String content;
    public ArrayList<Resource> resources;
}

class MetadataUsage {
    public String access;
}

class Name {
    public String label;
    public String content;
}

class Note {
    public String label;
    public String content;
}

class ObjectRight {
    public String label;
    public String content;
}

class ObjectType {
    public String label;
    public String content;
}

class OnlineMedia {
    public int mediaCount;
    public ArrayList<Medium> media;
}

class PhysicalDescription {
    public String label;
    public String content;
}

class Place {
    public String label;
    public String content;
}

class Resource {
    public int width;
    public int height;
    public String label;
    public String url;
    public String dimensions;
}

class SetName {
    public String label;
    public String content;
}

class Title {
    public String label;
    public String content;
}

class Usage {
    public String access;
}

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
}
