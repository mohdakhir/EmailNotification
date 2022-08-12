package com.coedify.sep.backend.CourseService.models.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name= "progress")
@Data
public class ProgressEntity extends BaseEntity{
    @Column(name="enrollment_id")
    private Long enrollmentId;

    @Column(name="topic_id")
    private Long topicId;

    @Column(name="module_id")
    private Long moduleId;

    @CreationTimestamp
    @Column(name = "start_date")
    private Instant startDate;

    @Column(name="end_date")
    private Instant endDate;
  
    @Column(name="marks")
    private Long marks;

    @Column(name="request_sent")
    private Boolean requestSent=false;




}
