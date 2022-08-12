package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import com.coedify.sep.backend.CourseService.commons.enums.TopicType;

import lombok.Data;

@Entity
@Table(name = "topics")
@Data
public class TopicEntity extends BaseEntity {

    @Column(name="name",unique=true)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="topic_type")
    private TopicType topicType;

    @Column(name="weightage")
    private Integer weightage;


   


    
}
