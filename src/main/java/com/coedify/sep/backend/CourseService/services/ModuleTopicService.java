package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.pojo.ModuleTopic;


public interface ModuleTopicService {
    public List<?> createModuleStructure( ModuleTopic moduleTopicRequest);
    void deleteModuleStructure(Long moduleId);
    public List<?> updateModuleStructure(ModuleTopic moduleTopicRequest);
    void deleteModuleStructureByTopicId(Long topicId);
}
