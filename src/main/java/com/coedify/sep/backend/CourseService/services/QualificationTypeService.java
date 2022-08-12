package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationTypeResponse;
import com.coedify.sep.backend.CourseService.models.pojo.QualificationType;

public interface QualificationTypeService {

  QualificationTypeResponse createQualificationType(QualificationTypeRequest request);

  List<QualificationTypeResponse> fetchAllQualificationType();

  QualificationTypeResponse fetchById(long id);

  void deleteById(long id);
  
}
