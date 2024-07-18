package com.desafiobossabox.dto;

import com.desafiobossabox.entity.Tools;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public record ToolsRequest(String title, String link, String description, List<String>tags){
    public Tools toModel() {
        Tools tools = new Tools();
        tools.setTitle(this.title);
        tools.setLink(this.link);
        tools.setDescription(this.description);
        tools.setTags(this.tags);
        return tools;
    }

}
