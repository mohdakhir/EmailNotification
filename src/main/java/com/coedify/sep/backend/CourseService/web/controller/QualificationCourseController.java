package com.coedify.sep.backend.CourseService.web.controller;


import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.QualificationCourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationCourseResponse;
import com.coedify.sep.backend.CourseService.services.QualificationCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class QualificationCourseController {
  
  @Autowired
  private QualificationCourseService qualificationCourseService;

    @PostMapping("/postQualificationCourse")
  public QualificationCourseResponse create(@RequestBody QualificationCourseRequest request) {

    return qualificationCourseService.createQualificationCourse(request);
  }

  @PostMapping("/getAllQualificationCourse")
  public List<QualificationCourseResponse> getAll() {
    return qualificationCourseService.fetchAll();
  }

  @PostMapping("/getQualificationCourseId")
  public QualificationCourseResponse getById(@RequestBody QualificationCourseRequest
  request) {

    return qualificationCourseService.fetchById(request.getId());
  }

  @PostMapping("/updateQualificationCourse")
  public QualificationCourseResponse update(@RequestBody QualificationCourseRequest request) {

    return qualificationCourseService.updateQualificationCourse(request);
  }

  @PostMapping("/deleteQualificationCourse")
  public void delete(@RequestBody QualificationCourseRequest request) {
    
     qualificationCourseService.deleteQualificationCourse(request.getId());
  }

  
}
