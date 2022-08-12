package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ModuleRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ModuleResponse;
import com.coedify.sep.backend.CourseService.models.entity.ModuleEntity;

public interface ModuleService {

    ModuleResponse saveModule(ModuleRequest request);

    List<ModuleResponse> getModule();

    ModuleResponse getModule(Long id);

    ModuleResponse getModuleStructure(Long id);

    List<ModuleResponse> getAllModuleStructures();

    void deleteModule(Long moduleId);

    ModuleResponse createAModule(ModuleRequest request);

    ModuleResponse updateAModule(Long moduleId, ModuleRequest request);

}
