package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationResponse;
import com.coedify.sep.backend.CourseService.models.pojo.QualificationDetails;

public interface QualificationService {

  QualificationResponse postQualification(QualificationRequest request);

  List<QualificationDetails> fetchAll();

  List<QualificationResponse> fetchByStaffId(Long id);

  List<QualificationResponse> updateQualification(List<QualificationRequest> request);

  void deleteQualification(Long staffId);

  
  
}
