package com.javalent.curio.features.items.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ItemSearchDTO {

    private List<String> tags = new ArrayList<>();
    private List<String> museums = new ArrayList<>();
    private String query;

    public List<String> getMuseums() {
        if (museums == null)
            return null;
        var arr = new ArrayList<String>();
        for (String museum : museums) {
            String replaced = museum.replaceAll("\\|", ",");
            ;
            arr.add(replaced);
        }
        return arr;
    }

}
