package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationCourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationCourseResponse;
import com.coedify.sep.backend.CourseService.models.entity.QualificationCourseEntity;

public class QualificationCourseConverter {
  
  public static QualificationCourseEntity requestToEntity(QualificationCourseRequest request) {
    
    QualificationCourseEntity entity = new QualificationCourseEntity();

    entity.setId(request.getId());
    entity.setQualificationCourse(request.getQualificationCourse());
    entity.setDuration(request.getDuration());

    return entity;
  }

  public static QualificationCourseResponse entityToResponse(QualificationCourseEntity entity) {
    
    QualificationCourseResponse response = new QualificationCourseResponse();

    response.setId(entity.getId());
    response.setQualificationCourse(entity.getQualificationCourse());
    response.setDuration(entity.getDuration());

    return response;
  }

  public static List<QualificationCourseEntity> listOfRequestToEntity(List<QualificationCourseRequest> requestList) {

    List<QualificationCourseEntity> entityList = new ArrayList<>();

    requestList.forEach(value -> {
      entityList.add(QualificationCourseConverter.requestToEntity(value));
    });

    return entityList;
  }

  public static List<QualificationCourseResponse> listOfEntityToResponse(List<QualificationCourseEntity> entityList){

    List<QualificationCourseResponse> responseList = new ArrayList<>();

    entityList.forEach(value->{
      responseList.add(QualificationCourseConverter.entityToResponse(value));
    });

    return responseList;
  }

  
}
