package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "courses")
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseEntity extends BaseEntity {
  
  @Column(name = "name",unique=true)
 
  private String name;

  @Column(name = "courseDescription")
  private String courseDescription;

}
