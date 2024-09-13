package com.javalent.curio.connectors.models.response;

import java.util.List;

import lombok.Data;

@Data
public abstract class ResponseItem {
    private ResponseItemContent content;

    private String id;
    private List<ResponseItemImage> images;
    private String institution;

    private String museum;

    private String title;

    /**
     * Content type
     */
    private String type;

    private String url;

    private String description;

}
