package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffResponse;
import com.coedify.sep.backend.CourseService.models.entity.StaffEntity;

public class StaffConverter {

    public static StaffEntity requestToEntity(StaffRequest request) {

        StaffEntity entity = new StaffEntity();
        entity.setId(request.getId());

        entity.setName(request.getName());

        entity.setEmail(request.getEmail());
        entity.setMobileNumber(request.getMobileNumber());
        entity.setStaffTypeId(request.getStaffTypeId());

        return entity;

    }

    public static StaffResponse entityToResponse(StaffEntity entity) {
        StaffResponse response = new StaffResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());

        response.setEmail(entity.getEmail());
        response.setMobileNumber(entity.getMobileNumber());

        return response;
    }

    public static List<StaffResponse> entityListToResponseList(List<StaffEntity> entityList) {
        List<StaffResponse> responseList = new LinkedList<>();

        entityList.forEach(entity -> {

            responseList.add(entityToResponse(entity));
        });

        return responseList;
    }

    public static List<StaffEntity> requestListToEntityList(List<StaffRequest> requestList) {
        List<StaffEntity> entityList = new LinkedList<>();

        requestList.forEach(request -> {

            entityList.add(requestToEntity(request));
        });

        return entityList;
    }

}
