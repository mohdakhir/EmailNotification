package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationResponse;
import com.coedify.sep.backend.CourseService.models.entity.QualificationEntity;

public class QualificationConverter {
  
  public static QualificationEntity requestToEntity(QualificationRequest request) {

    QualificationEntity entity = new QualificationEntity();

    entity.setCgpa(request.getCgpa());
    entity.setEndDate(request.getEndDate());
    entity.setId(request.getId());
    entity.setQualificationCourseId(request.getQualificationCourseId());
    entity.setQualificationTypeId(request.getQualificationTypeId());
    entity.setStaffId(request.getStaffId());
    entity.setStartDate(request.getStartDate());
    entity.setUniversityBoard(request.getUniversityBoard());
    

    return entity;

  }

  public static QualificationResponse entityToResponse(QualificationEntity entity) {

    QualificationResponse response = new QualificationResponse();

    response.setCgpa(entity.getCgpa());
    response.setEndDate(entity.getEndDate());
    response.setId(entity.getId());
    response.setQualificationCourseId(entity.getQualificationCourseId());
    response.setQualificationTypeId(entity.getQualificationTypeId());
    response.setStaffId(entity.getStaffId());
    response.setStartDate(entity.getStartDate());
    response.setUniversityBoard(entity.getUniversityBoard());

    return response;
  }
  
  public static List<QualificationEntity> listOfRequestToEntity(List<QualificationRequest> request) {

    List<QualificationEntity> entity = new ArrayList<>();

    request.forEach(value -> {
      entity.add(QualificationConverter.requestToEntity(value));
    });

    return entity;

  }
  
  public static List<QualificationResponse> listOfEntityToResponse(List<QualificationEntity> entity) {
    
    List<QualificationResponse> response = new ArrayList<>();

    entity.forEach(value -> {
      response.add(QualificationConverter.entityToResponse(value));
    });

    return response;
  }
  

}
