package com.coedify.sep.backend.CourseService.services.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.commons.APIResponse;
import com.coedify.sep.backend.CourseService.commons.converter.CourseConverter;
import com.coedify.sep.backend.CourseService.commons.converter.ModuleConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.CourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.ModuleResponse;
import com.coedify.sep.backend.CourseService.models.pojo.CourseModule;
import com.coedify.sep.backend.CourseService.models.repository.CourseModuleRepository;
import com.coedify.sep.backend.CourseService.models.repository.CourseRepository;
import com.coedify.sep.backend.CourseService.models.repository.ModuleRepository;
import com.coedify.sep.backend.CourseService.services.CourseModuleService;
import com.coedify.sep.backend.CourseService.services.CourseService;
import com.coedify.sep.backend.CourseService.services.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseModuleRepository courseModuleRepository;

    @Autowired
    ModuleService moduleService;

    @Autowired
    CourseModuleService courseModuleService;

    @Autowired
    ModuleRepository moduleRepository;


    @Override
    public CourseResponse saveACourse(CourseRequest courseRequest){             
    
        log.info("Saving Course ");
        return CourseConverter.entityToResponse(courseRepository.save(CourseConverter.requestToEntity(courseRequest)));
    }

    @Override
    public CourseResponse getCourse(Long courseId){
        log.info("fetching Course by Id",courseId);
        return CourseConverter.entityToResponse(courseRepository.findById(courseId).get());
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        log.info("fetching Courses");
        return CourseConverter.listOfEntityToResponses(courseRepository.findAll());
    }

    @Override
    public CourseResponse getCourseStructure(Long courseId){
        log.info("fetching Course Structure by course id",courseId);
        CourseResponse courseResponse=getCourse(courseId);
        List<ModuleResponse> list=ModuleConverter.listOfEntityToResponses(moduleRepository.getAllModules(courseId)) ;
        
        List<ModuleResponse> listResponse = new LinkedList<>();
        list.forEach(value->{
            ModuleResponse response = moduleService.getModuleStructure(value.getId());
            listResponse.add(response);
        });


        courseResponse.setModuleList(listResponse);
        return courseResponse;

            
    }

    @Override
    public APIResponse getAllCourseStructures() {
        log.info("fetching Course Structure ");
        
        List<CourseResponse> list = getAllCourses();
        List<CourseResponse> responseList = new LinkedList<>();

        list.forEach(value->{
            responseList.add(getCourseStructure(value.getId()));
        });
        Map courses = new HashMap();
        courses.put("courses",responseList);
        APIResponse response = new APIResponse(200,null,courses);
        return response;
    }

    @Override
    public CourseResponse createACourse(CourseRequest request) {
        log.info("saving Course ");
        CourseResponse response = saveACourse(request);
        CourseModule courseModuleRequest = new  CourseModule();
        courseModuleRequest.setCourseId(response.getId());
        courseModuleRequest.setModuleIds(request.getModuleList());
        log.info("saving Course Structure");
        courseModuleService.saveCourseModule(courseModuleRequest);

        return getCourseStructure(response.getId());
    }

    @Transactional
    public void deleteCourse(Long courseId){
        log.info("Delete Course by id",courseId);
        courseRepository.deleteById(courseId);
        log.info("Delete Course structure by id",courseId);
        courseModuleService.deleteCourseStructure(courseId);
    }

    @Override
    public CourseResponse updateACourse(Long courseId, CourseRequest request) {
        request.setId(courseId);
        CourseResponse response = saveACourse(request);
        CourseModule courseModuleRequest = new CourseModule();
        courseModuleRequest.setCourseId(courseId);
        courseModuleRequest.setModuleIds(request.getModuleList());
        courseModuleService.updateCourseStructure(courseModuleRequest);
        log.info("update Course by id",courseId);
        return getCourseStructure(response.getId());
    }


    
    
}
