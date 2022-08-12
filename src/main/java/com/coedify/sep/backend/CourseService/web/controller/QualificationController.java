package com.coedify.sep.backend.CourseService.web.controller;


import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationResponse;
import com.coedify.sep.backend.CourseService.models.pojo.QualificationDetails;
import com.coedify.sep.backend.CourseService.services.QualificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1")
public class QualificationController {

  @Autowired
  private QualificationService qualificationService;

  @PostMapping("/qualification")
  public QualificationResponse create(@RequestBody QualificationRequest request) {

    return qualificationService.postQualification(request);
  }

  @PostMapping("/getAllqualifications")
  public List<QualificationDetails> getAll() {

    return qualificationService.fetchAll();
  }

  @PostMapping("/qualificationByStaffId")
  public List<QualificationResponse> getById(@RequestBody QualificationRequest request) {

    return qualificationService.fetchByStaffId(request.getStaffId());
  }

  @PostMapping("/qualificationUpdate")
  public List<QualificationResponse> update(@RequestBody List<QualificationRequest> request) {

    return qualificationService.updateQualification(request);
  }

  @PostMapping("/qualificationDelete")
  public void delete(@RequestBody QualificationRequest request) {

    qualificationService.deleteQualification(request.getStaffId());
  }

  
}
