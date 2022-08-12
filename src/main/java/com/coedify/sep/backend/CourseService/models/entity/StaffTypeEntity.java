package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "staffType")
@Data
public class StaffTypeEntity extends BaseEntity {

    @Column(name = "staff_type")
    private String staffType;

}
