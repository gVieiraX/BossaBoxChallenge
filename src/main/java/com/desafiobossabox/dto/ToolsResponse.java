package com.desafiobossabox.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public record ToolsResponse(Long id, String title, String link, String description, List<String> tags) {

    public ToolsResponse(Long id, String title, String link, String description, List<String> tags) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }


}
