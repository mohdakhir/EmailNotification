package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.converter.QualificationCourseConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.QualificationCourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationCourseResponse;
import com.coedify.sep.backend.CourseService.models.entity.QualificationCourseEntity;
import com.coedify.sep.backend.CourseService.models.repository.QualificationCourseRepository;
import com.coedify.sep.backend.CourseService.services.QualificationCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualificationCourseServiceImpl implements QualificationCourseService {

  @Autowired
  private QualificationCourseRepository qualificationCourseRepository;

  @Override
  public QualificationCourseResponse createQualificationCourse(QualificationCourseRequest request) {

    return QualificationCourseConverter
        .entityToResponse(qualificationCourseRepository.save(QualificationCourseConverter.requestToEntity(request)));
  }

  @Override
  public List<QualificationCourseResponse> fetchAll() {

    return QualificationCourseConverter.listOfEntityToResponse(qualificationCourseRepository.findAll());
  }

  @Override
  public QualificationCourseResponse fetchById(long id) {

    return QualificationCourseConverter.entityToResponse(qualificationCourseRepository.findById(id).get());
  }

  @Override
  public QualificationCourseResponse updateQualificationCourse(QualificationCourseRequest request) {
     
     return QualificationCourseConverter.entityToResponse(qualificationCourseRepository.save(
         QualificationCourseConverter.requestToEntity(request)));
    
  }

  @Override
  public void deleteQualificationCourse(long id) {
    qualificationCourseRepository.deleteById(id);

  }
}
