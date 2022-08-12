package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationTypeResponse;
import com.coedify.sep.backend.CourseService.models.entity.QualificationTypeEntity;

public class QualificationTypeConverter {

  public static QualificationTypeEntity requestToEntity(QualificationTypeRequest request) {

    QualificationTypeEntity entity = new QualificationTypeEntity();

    entity.setId(request.getId());
    entity.setQualificationType(request.getQualificationType());

    return entity;

  }

  public static QualificationTypeResponse entityToResponse(QualificationTypeEntity entity) {

    QualificationTypeResponse response = new QualificationTypeResponse();

    response.setId(entity.getId());
    response.setQualificationType(entity.getQualificationType());

    return response;
  }

  
  public static List<QualificationTypeEntity> requestListToEntityList(List<QualificationTypeRequest> requestList) {

    List<QualificationTypeEntity> entityList = new ArrayList<>();

    requestList.forEach(value -> {
      entityList.add(QualificationTypeConverter.requestToEntity(value));
    });

    return entityList;

  }

  public static List<QualificationTypeResponse> entityListToResponseList(List<QualificationTypeEntity> entityList) {

    List<QualificationTypeResponse> responseList = new ArrayList<>();

    entityList.forEach(value -> {
      responseList.add(QualificationTypeConverter.entityToResponse(value));
    });

    return responseList;
  }

}
