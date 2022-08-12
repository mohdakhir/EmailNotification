package com.coedify.sep.backend.CourseService.models.pojo;

import java.time.Instant;

public interface QualificationDetails {

  public Long getId();

  //public String getName();

  public String getType();

  public String getQualificationCourse();

  public String getUniversityBoard();

  public Float getCgpa();
  
  public Instant getStartDate();

  public Instant getEndDate();

}
