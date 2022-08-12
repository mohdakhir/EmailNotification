package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ExperienceRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ExperienceResponse;
import com.coedify.sep.backend.CourseService.models.entity.ExperienceEntity;

public class ExperienceConverter {

    public static ExperienceEntity requestToEntity(ExperienceRequest request) {
        ExperienceEntity entity = new ExperienceEntity();
        entity.setId(request.getId());
        entity.setComapanyName(request.getComapanyName());
        entity.setDesignation(request.getDesignation());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        entity.setSkillSet(request.getSkillSet());
        entity.setStaffid(request.getStaffid());

        return entity;

    }

    public static ExperienceResponse entityToResponse(ExperienceEntity entity) {

        ExperienceResponse response = new ExperienceResponse();
        response.setId(entity.getId());
        response.setComapanyName(entity.getComapanyName());
        response.setStartDate(entity.getStartDate());
        response.setEndDate(entity.getEndDate());
        response.setDesignation(entity.getDesignation());
        response.setSkillSet(entity.getSkillSet());
        response.setStaffid(entity.getStaffid());

        return response;

    }

    public static List<ExperienceResponse> entityListToResponseList(List<ExperienceEntity> listOfEntities) {
        List<ExperienceResponse> listOfResponse = new LinkedList<>();
        listOfEntities.forEach(entity -> {
            listOfResponse.add(entityToResponse(entity));

        });
        return listOfResponse;

    }

    public static List<ExperienceEntity> requestListToEntityList(List<ExperienceRequest> listOfRequest) {
        List<ExperienceEntity> listOfEntitiy = new LinkedList<>();
        listOfRequest.forEach(request -> {
            listOfEntitiy.add(requestToEntity(request));

        });

        return listOfEntitiy;

    }
}