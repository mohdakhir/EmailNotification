package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course_module")
@Data
 public class CourseModuleEntity  extends BaseEntity{
    @Column(name="courseId")
    private Long courseId;

    @Column(name="moduleId")
    private Long moduleId;

    @Column(name="module_order")
    private Integer moduleOrder;

    
}
