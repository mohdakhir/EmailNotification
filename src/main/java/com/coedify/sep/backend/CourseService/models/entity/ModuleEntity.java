package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Table(name= "modules")
@Data
@EqualsAndHashCode(callSuper = false)
public class ModuleEntity extends BaseEntity {
    
    @Column(name="name",unique=true)
    private String name;

    @Column(name="description")
    private String description;


   
   
}
