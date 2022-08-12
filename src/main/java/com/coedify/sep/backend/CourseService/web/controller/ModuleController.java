package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ModuleRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ModuleResponse;
import com.coedify.sep.backend.CourseService.models.entity.ModuleEntity;
import com.coedify.sep.backend.CourseService.models.repository.ModuleTopicRepository;
import com.coedify.sep.backend.CourseService.services.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @Autowired
    ModuleTopicRepository moduleTopicRepository;

    @GetMapping("/module/{moduleId}")
    public ModuleResponse getModuleStructure(@PathVariable Long moduleId) {
        return moduleService.getModuleStructure(moduleId);
    }

    @GetMapping("/module")
    public List<ModuleResponse> getAllModuleStructures() {
        return moduleService.getAllModuleStructures();

    }

    @PostMapping("/module")
    public ModuleResponse createAModule(@RequestBody ModuleRequest request) {
        return moduleService.createAModule(request);
    }

    @DeleteMapping("/module/{moduleId}")
    public void deleteModuleById(@PathVariable Long moduleId) {
        moduleService.deleteModule(moduleId);
    }

    @PutMapping("/module/{moduleId}")
    public ModuleResponse updateAModule(@PathVariable Long moduleId, @RequestBody ModuleRequest request) {
        return moduleService.updateAModule(moduleId, request);
    }

}
