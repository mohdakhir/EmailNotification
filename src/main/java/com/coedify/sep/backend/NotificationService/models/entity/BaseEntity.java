package com.coedify.sep.backend.NotificationService.models.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    @Column(name = "createdDate")
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = "updatedDate")
    private Instant updatedDate;
}
