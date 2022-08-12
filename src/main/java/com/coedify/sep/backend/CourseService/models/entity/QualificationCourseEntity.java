package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="qualification_course")
public class QualificationCourseEntity extends BaseEntity {
  
  @Column(name="qualification_course")
  private String qualificationCourse;
  
  @Column(name="duration")
  private Long duration;
}
