package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="staff")
@Data
public class StaffEntity extends BaseEntity  {

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "mobile_number",unique = true)
    private Long mobileNumber;

    @Column(name = "staff_type_id")
    private Long staffTypeId;
 
}
