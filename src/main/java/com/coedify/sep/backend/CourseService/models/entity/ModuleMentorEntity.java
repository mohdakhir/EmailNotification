package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="moduleMentor")
@Data
public class ModuleMentorEntity extends BaseEntity {
    
    @Column(name="moduleId")
    private Long moduleId;

    @Column(name="mentorId")
    private Long mentorId;
}
