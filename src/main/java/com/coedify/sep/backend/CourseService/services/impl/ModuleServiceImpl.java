package com.coedify.sep.backend.CourseService.services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.commons.converter.ModuleConverter;
import com.coedify.sep.backend.CourseService.commons.converter.TopicConverter;
import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.CourseService.models.dto.request.ModuleRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ModuleResponse;
import com.coedify.sep.backend.CourseService.models.entity.ModuleEntity;
import com.coedify.sep.backend.CourseService.models.entity.TopicEntity;
import com.coedify.sep.backend.CourseService.models.pojo.ModuleTopic;
import com.coedify.sep.backend.CourseService.models.repository.ModuleRepository;
import com.coedify.sep.backend.CourseService.models.repository.ModuleTopicRepository;
import com.coedify.sep.backend.CourseService.models.repository.TopicRepository;
import com.coedify.sep.backend.CourseService.services.CourseModuleService;
import com.coedify.sep.backend.CourseService.services.ModuleService;
import com.coedify.sep.backend.CourseService.services.ModuleTopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    ModuleTopicRepository moduleTopicRepository;

    @Autowired
    ModuleTopicService moduleTopicService;

    @Autowired
    CourseModuleService courseModuleService;

    @Autowired
    TopicRepository topicRepository;

    @Override
    public ModuleResponse saveModule(ModuleRequest request) {
        return ModuleConverter.entityToResponse(moduleRepository.save(ModuleConverter.requestToEntity(request)));
    }

    @Override
    public List<ModuleResponse> getModule() {
        List<ModuleEntity> moduleEntity = moduleRepository.findAll();
        List<ModuleResponse> response = ModuleConverter.listOfEntityToResponses(moduleEntity);
        return response;
    }

    // if((studentId>=studentService.theStudent.size() || (studentId<0))){
    //     throw new StudentNotFoundException("Student Id not found- "+ studentId);
    // }

    @Override
    public ModuleResponse getModule(Long id) {

         
        return ModuleConverter.entityToResponse(moduleRepository.getById(id));
    }


    @Override
    public ModuleResponse getModuleStructure(Long moduleId) {
       
        if(!moduleRepository.existsById(moduleId)){
            throw new AssetNotFoundException("Asset not found");
        }

        List<TopicEntity> list = topicRepository.getAllTopics(moduleId);
        ModuleResponse moduleResponse = getModule(moduleId);

        moduleResponse.setTopicList(TopicConverter.entityListToResponseList(list));

        

        return moduleResponse;
    }

    @Override
    public List<ModuleResponse> getAllModuleStructures() {
        List<ModuleResponse> responseList = getModule();
        List<ModuleResponse> finalResponseList = new LinkedList<>();
        responseList.forEach(value->{
            finalResponseList.add(getModuleStructure(value.getId()));
        });
        return finalResponseList;
    }

    @Override
    public ModuleResponse createAModule(ModuleRequest request) {
        ModuleResponse response = saveModule(request);
        ModuleTopic moduleTopicRequest = new ModuleTopic();
        moduleTopicRequest.setModuleId(response.getId());
        moduleTopicRequest.setTopicId(request.getTopicList());
        moduleTopicService.createModuleStructure(moduleTopicRequest);

        return getModuleStructure(response.getId());
    }

    @Override
    @Transactional
    public void deleteModule(Long moduleId) {
        moduleRepository.deleteById(moduleId);
        moduleTopicService.deleteModuleStructure(moduleId);
        courseModuleService.deleteCourseStructureByModuleId(moduleId);     
    }

    @Override
    public ModuleResponse updateAModule(Long moduleId, ModuleRequest request) {
        
        request.setId(moduleId);
        ModuleResponse response = saveModule(request);
        ModuleTopic moduleTopicRequest = new ModuleTopic();
        moduleTopicRequest.setModuleId(moduleId);
        moduleTopicRequest.setTopicId(request.getTopicList());
        moduleTopicService.updateModuleStructure(moduleTopicRequest);

        return getModuleStructure(response.getId());
    }

   

}
