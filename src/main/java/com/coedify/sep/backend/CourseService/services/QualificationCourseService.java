package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationCourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationCourseResponse;

public interface QualificationCourseService {

  QualificationCourseResponse createQualificationCourse(QualificationCourseRequest request);

  List<QualificationCourseResponse> fetchAll();

  QualificationCourseResponse fetchById(long id);

  QualificationCourseResponse updateQualificationCourse(QualificationCourseRequest request);

  void deleteQualificationCourse(long id);

  
}
