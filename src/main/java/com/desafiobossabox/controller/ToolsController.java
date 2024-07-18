package com.desafiobossabox.controller;

import com.desafiobossabox.dto.ToolsRequest;
import com.desafiobossabox.dto.ToolsResponse;
import com.desafiobossabox.entity.Tools;
import com.desafiobossabox.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    private final ToolsService toolsService;

    @Autowired
    public ToolsController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    @GetMapping
    public ResponseEntity<List<Tools>> getAllTools() {
        List<Tools> getAllTools = toolsService.getAllTools();
        return ResponseEntity.ok().body(getAllTools);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tools>> getToolsByTag(@RequestParam String tag) {
        List<Tools> toolsByTag = toolsService.getToolsByTag(tag);
        return ResponseEntity.ok().body(toolsByTag);
    }

    @PostMapping
    public ResponseEntity<ToolsResponse> saveToolsResponseEntity(@RequestBody ToolsRequest toolsRequests) {
        Tools toolsRequestsModel = toolsRequests.toModel();
        ToolsResponse toolsResponse = toolsService.saveTools(toolsRequestsModel);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(toolsResponse.id())
                .toUri();

        return ResponseEntity.created(headerLocation).body(toolsResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTools(@PathVariable Long id) {
        toolsService.deleteById(id);
        return ResponseEntity.ok().body("Tools Deleted Successfully");
    }
}
