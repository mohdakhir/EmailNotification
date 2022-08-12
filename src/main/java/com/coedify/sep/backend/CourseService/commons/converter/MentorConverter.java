package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.MentorRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.MentorResponse;
import com.coedify.sep.backend.CourseService.models.entity.MentorEntity;

public class MentorConverter {

    public static MentorEntity requestToEntity(MentorRequest request){

        MentorEntity entity = new MentorEntity();

        entity.setId(request.getId());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setCreatedDate(request.getCreatedDate());
        entity.setUpdatedBy(request.getUpdatedBy());
        entity.setName(request.getName());
        entity.setSkypeId(request.getSkypeId());
        entity.setContact(request.getContact());

        return entity;
        
    }

    public static MentorResponse entityToResponse(MentorEntity entity){

        MentorResponse response = new MentorResponse();
        
        response.setId(entity.getId());
        response.setCreatedBy(entity.getCreatedBy());
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedBy(entity.getUpdatedBy());
        response.setName(entity.getName());
        response.setSkypeId(entity.getSkypeId());
        response.setContact(entity.getContact());


        return response;
        
    }

    public static List<MentorResponse> listOfEntityToResponses(List<MentorEntity> entityList){
        List<MentorResponse> listResponse = new LinkedList<MentorResponse>();
        entityList.forEach(entity -> {
            listResponse.add(entityToResponse(entity));
        });

        return listResponse;
    }
    
    public static List<MentorEntity> listOfResponseToEntities(List<MentorRequest> requestList){
        List<MentorEntity> listEntity = new LinkedList<MentorEntity>();
        requestList.forEach(request -> {
            listEntity.add(requestToEntity(request));
        });

        return listEntity;
    }
}
