package com.desafiobossabox.service;

import com.desafiobossabox.dto.ToolsResponse;
import com.desafiobossabox.entity.Tools;
import com.desafiobossabox.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsService {

    private final ToolsRepository toolsRepository;

    @Autowired
    public ToolsService(ToolsRepository toolsRepository) {
        this.toolsRepository = toolsRepository;
    }

    public List<Tools> getAllTools() {
        return toolsRepository.findAll();
    }

    public List<Tools> getToolsByTag(String tag) {
        return toolsRepository.findByTagsContaining(tag);
    }

    public ToolsResponse saveTools(Tools tools) {
        Tools toolsSaved = toolsRepository.save(tools);
        return new ToolsResponse(toolsSaved.getId(), toolsSaved.getTitle(), toolsSaved.getLink(), toolsSaved.getDescription(), toolsSaved.getTags());
    }

    public void deleteById(Long id) {
        toolsRepository.deleteById(id);
    }
}
