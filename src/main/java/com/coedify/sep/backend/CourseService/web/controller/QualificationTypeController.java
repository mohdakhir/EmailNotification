package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationTypeResponse;
import com.coedify.sep.backend.CourseService.services.QualificationTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class QualificationTypeController {

  @Autowired
  private QualificationTypeService qualificationTypeService;

  @PostMapping("/qualificationType")
  public QualificationTypeResponse create(@RequestBody QualificationTypeRequest request) {

    return qualificationTypeService.createQualificationType(request);
  }

  @PostMapping("/getAllqualificationTypes")
  public List<QualificationTypeResponse> getAll() {

    return qualificationTypeService.fetchAllQualificationType();
  }

  @PostMapping("/getQualificationById")
  public QualificationTypeResponse getById(@RequestBody QualificationTypeRequest request) {
    return qualificationTypeService.fetchById(request.getId());
  }

  public void delete(@RequestBody QualificationTypeRequest request) {

    qualificationTypeService.deleteById(request.getId());
  }

}
