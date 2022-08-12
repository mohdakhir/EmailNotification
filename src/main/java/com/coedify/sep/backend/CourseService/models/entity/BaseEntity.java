package com.coedify.sep.backend.CourseService.models.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "createdBy")
    private String createdBy;
    
    @CreationTimestamp
    @Column(name = "createdDate")
    private Instant createdDate;

    @Column(name = "updatedBy")
    private String updatedBy;
    
    @UpdateTimestamp
    @Column(name = "updatedDate")
    private Instant updatedDate;
}
