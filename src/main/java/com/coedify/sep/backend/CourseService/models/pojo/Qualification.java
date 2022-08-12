package com.coedify.sep.backend.CourseService.models.pojo;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Qualification extends Base {

  private Long qualificationTypeId;

  private Long universityBoard;

  private Long qualificationCourseId;

  private Float cgpa;

  private Instant startDate;

  private Instant endDate;

  private Long staffId;


}


