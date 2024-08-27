package com.javalent.curio.controller.items;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ItemDTO {

    private List<String> tags = new ArrayList<>();
    private List<String> museums = new ArrayList<>();

    public List<String> getMuseums() {
        var arr = new ArrayList<String>();
        for (String museum : museums) {
            String replaced = museum.replaceAll("\\|", ",");
            ;
            arr.add(replaced);
        }
        return arr;
    }

}
