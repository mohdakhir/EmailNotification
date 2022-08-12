package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.CourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.models.entity.CourseEntity;

public class CourseConverter {

    public static CourseResponse entityToResponse(CourseEntity entity){
        CourseResponse response = new CourseResponse();

        response.setId(entity.getId());
        response.setCreatedBy(entity.getCreatedBy());
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedBy(entity.getUpdatedBy());
        response.setName(entity.getName());
        response.setCourseDescription(entity.getCourseDescription());
        
        return response;
    }
    
    public static CourseEntity requestToEntity(CourseRequest request){
        CourseEntity entity = new CourseEntity();

        entity.setId(request.getId());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setCreatedDate(request.getCreatedDate());
        entity.setUpdatedBy(request.getUpdatedBy());
        entity.setName(request.getName());
        entity.setCourseDescription(request.getCourseDescription());
        
        return entity;
    }

    public static List<CourseResponse> listOfEntityToResponses(List<CourseEntity> entityList){
        List<CourseResponse> listResponse = new LinkedList<CourseResponse>();
        entityList.forEach(entity -> {
            listResponse.add(entityToResponse(entity));
        });

        return listResponse;
    }
    
    public static List<CourseEntity> listOfResponseToEntities(List<CourseRequest> requestList){
        List<CourseEntity> listEntity = new LinkedList<CourseEntity>();
        requestList.forEach(request -> {
            listEntity.add(requestToEntity(request));
        });

        return listEntity;
    }
}
