package com.desafiobossabox.service;

import com.desafiobossabox.dto.ToolsResponse;
import com.desafiobossabox.entity.Tools;
import com.desafiobossabox.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ToolsService {

    @Autowired
    private ToolsRepository toolsRepository;

    public List<Tools> getAllTools(){
        List<Tools> toolsList = toolsRepository.findAll();
        return toolsList;
    }

    public List<Tools> getToolsByTag(String tags){
        List<Tools> toolsListByTag = toolsRepository.findByTags(tags);
        return toolsListByTag;
    }

    public ToolsResponse saveTools(@RequestBody Tools tools){
       toolsRepository.save(tools);
        ToolsResponse toolsResponse = new ToolsResponse(tools.getId(),
                tools.getTitle(),
                tools.getLink(),
                tools.getDescription(),
                tools.getTags());
        return toolsResponse;
    }

    public void deleteById(Long id){
        toolsRepository.deleteById(id);
    }


}
