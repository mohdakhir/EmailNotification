package com.coedify.sep.backend.CourseService.models.entity;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Table(name= "module_topic")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ModuleTopicEntity extends BaseEntity{
    @Column(name="module_id")
    private Long moduleId;

    @Column(name="topic_id")
    private Long topicId;

    @Column(name="topic_order")
    private Integer topicOrder;

}
