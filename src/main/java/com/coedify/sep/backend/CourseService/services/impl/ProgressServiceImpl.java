package com.coedify.sep.backend.CourseService.services.impl;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coedify.sep.backend.CourseService.commons.APIResponse;
import com.coedify.sep.backend.CourseService.commons.converter.ProgressConverter;
import com.coedify.sep.backend.CourseService.commons.converter.StaffEnrollmentConverter;
import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.CourseService.exception.TopicIdAlreadyExist;
import com.coedify.sep.backend.CourseService.models.dto.request.ProgressRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.ProgressResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffEnrollmentResponse;
import com.coedify.sep.backend.CourseService.models.entity.ProgressEntity;
import com.coedify.sep.backend.CourseService.models.repository.DeveloperEnrollmentRepository;
import com.coedify.sep.backend.CourseService.models.repository.ModuleRepository;
import com.coedify.sep.backend.CourseService.models.repository.ProgressRepository;
import com.coedify.sep.backend.CourseService.models.repository.TopicRepository;
import com.coedify.sep.backend.CourseService.services.CourseService;
import com.coedify.sep.backend.CourseService.services.ProgressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProgressServiceImpl implements ProgressService{
    

    @Autowired
    ProgressRepository progressRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    DeveloperEnrollmentRepository developerEnrollmentRepository;

    @Autowired
    CourseService courseService;

    @Override
    public Long topicsCovered(Long enrollmentId) {
       
        return progressRepository.topicsCovered(enrollmentId);
    }

    @Override
    public ProgressResponse createProgress(ProgressRequest progressRequest){
        Long topicId=progressRequest.getTopicId();
        if(!topicRepository.existsById(topicId))
            throw new AssetNotFoundException("Topic Id does not exist in topic table");
        Long enrollmentId=progressRequest.getEnrollmentId();
        if(!developerEnrollmentRepository.existsById(enrollmentId))
            throw new AssetNotFoundException("Enrollment Id does not exist in topic table");
        Long moduleId=progressRequest.getModuleId();
        if(!moduleRepository.existsById(moduleId))
            throw new AssetNotFoundException("Module Id does not exist in topic table");
            
       if((progressRepository.getEntity(enrollmentId, topicId,moduleId)!=null))
        
            throw new TopicIdAlreadyExist("Topic Id already exist for this enrolment and module Id");
        
        
        
       return ProgressConverter.entityToResponse(progressRepository.save(ProgressConverter.requestToEntity(progressRequest)));
    
       
       
    }

    
    

    

    @Override
    public Boolean isTopicCompleted(ProgressRequest progressRequest){
        Long topicId=progressRequest.getTopicId();
        Long enrollmentId=progressRequest.getEnrollmentId();
        Long moduleId=progressRequest.getModuleId();
        Instant endDate=progressRepository.getEndDateByUs(enrollmentId, topicId,moduleId);
        if(endDate==null)
            return false;
        else
            return true;

            
        
    
    }

    @Override
    public APIResponse getProgressbyEnrollmentId(Long enrollId){
        List<ProgressResponse> enrollmentProgress = ProgressConverter.listOfEntityToResponse(progressRepository.findByEnrollmentId(enrollId));
        StaffEnrollmentResponse enrollment = StaffEnrollmentConverter.entityToResponse(developerEnrollmentRepository.findById(enrollId).get());
        CourseResponse course = courseService.getCourseStructure(enrollment.getCourseId());

        Map response = new HashMap();
        response.put("enrollment",enrollment);
        response.put("course",course);
        response.put("progress", enrollmentProgress);

        APIResponse apiResponse = new APIResponse(200,null,response);
        
        return apiResponse;
    }

    // @Override
    // public ProgressResponse updateProgress(Long id,ProgressRequest progressRequest){
    //     progressRepository.deleteById(id);
    //     progressRequest.setId(id);
        
    //     return createProgress(progressRequest);

    // }
    
}
