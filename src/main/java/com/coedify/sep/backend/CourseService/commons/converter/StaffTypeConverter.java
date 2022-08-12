package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffTypeResponse;
import com.coedify.sep.backend.CourseService.models.entity.StaffTypeEntity;

public class StaffTypeConverter {

    public static StaffTypeResponse entityToResponse(StaffTypeEntity entity) {
        StaffTypeResponse response = new StaffTypeResponse();

        response.setId(entity.getId());
        response.setStaffType(entity.getStaffType());
        return response;
    }

    public static StaffTypeEntity requestToEntity(StaffTypeRequest request) {
        StaffTypeEntity entity = new StaffTypeEntity();
        entity.setId(request.getId());
        entity.setStaffType(request.getStaffType());
        return entity;
    }

    public static List<StaffTypeResponse> entityListToResponseList(List<StaffTypeEntity> entityList) {
        List<StaffTypeResponse> responseList = new LinkedList<StaffTypeResponse>();
        entityList.forEach(entity -> {
            responseList.add(entityToResponse(entity));
        });
        return responseList;

    }

    public static List<StaffTypeEntity> requestListToEntityList(List<StaffTypeRequest> requestList) {
        List<StaffTypeEntity> entityList = new LinkedList<StaffTypeEntity>();
        requestList.forEach(request -> {
            entityList.add(requestToEntity(request));

        });
        return entityList;
    }
}
