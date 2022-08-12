package com.coedify.sep.backend.CourseService.models.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="developer_enrollment")
@Data
@EqualsAndHashCode(callSuper = false)
public class StaffEnrollmentEntity extends BaseEntity{

    private Long courseId;

    private Long staffId;

    @CreationTimestamp
    private Instant startDate;

    private Instant tentativeEndDate;

    private Instant extendedDate;

    private Instant completionDate;
    
}

