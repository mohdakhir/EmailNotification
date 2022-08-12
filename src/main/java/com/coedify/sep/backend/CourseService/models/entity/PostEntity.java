package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "post")
public class PostEntity extends BaseEntity{

    @Column(name="ModuleId")   
    private Long moduleId;

    @Column (name="postTitle")
    private String postTitle;
    
    @Column(name="postBody")
    private String postBody;

    @Column(name="userId")
    private String userId;


}
