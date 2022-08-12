package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ProgressRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ProgressResponse;
import com.coedify.sep.backend.CourseService.models.entity.ProgressEntity;

public class ProgressConverter {
    

    public static ProgressEntity requestToEntity(ProgressRequest progressRequest){
        
       ProgressEntity entity = new ProgressEntity();

        entity.setId(progressRequest.getId());
        entity.setCreatedBy(progressRequest.getCreatedBy());
        entity.setCreatedDate(progressRequest.getCreatedDate());
        entity.setTopicId(progressRequest.getTopicId());
        entity.setEnrollmentId(progressRequest.getEnrollmentId());
        entity.setModuleId(progressRequest.getModuleId());
        entity.setStartDate(progressRequest.getStartDate());
        entity.setEndDate(progressRequest.getEndDate());
        entity.setUpdatedBy(progressRequest.getUpdatedBy());
        entity.setUpdatedDate(progressRequest.getUpdatedDate());

        
        return entity;
    }

    public static ProgressResponse entityToResponse(ProgressEntity progressEntity){
       
        ProgressResponse response = new ProgressResponse();
             
        response.setId(progressEntity.getId());
        response.setCreatedBy(progressEntity.getCreatedBy());
        response.setCreatedDate(progressEntity.getCreatedDate());
        response.setTopicId(progressEntity.getTopicId());
        response.setEnrollmentId(progressEntity.getEnrollmentId());
        response.setModuleId(progressEntity.getModuleId());
        response.setStartDate(progressEntity.getStartDate());
        response.setEndDate(progressEntity.getEndDate());
        response.setUpdatedBy(progressEntity.getUpdatedBy());
        response.setUpdatedDate(progressEntity.getUpdatedDate());
       
        return response;
    }
    public static List<ProgressEntity> listOfRequestToEntity(List<ProgressRequest> request){
        List<ProgressEntity> entity = new LinkedList<>();

        request.forEach(value->{
            entity.add(requestToEntity(value));
        });

        return entity;
    }
    public static List<ProgressResponse> listOfEntityToResponse(List<ProgressEntity> entity){
        List<ProgressResponse> listOfResponse= new LinkedList<>();

        entity.forEach(value->{
            listOfResponse.add(entityToResponse(value));
        });

        return listOfResponse;
    }
     

}
