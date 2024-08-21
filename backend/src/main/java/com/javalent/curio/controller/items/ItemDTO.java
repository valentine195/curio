package com.javalent.curio.controller.items;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ItemDTO {

    private List<String> tags = new ArrayList<>();
    private List<String> museums = new ArrayList<>();

}
