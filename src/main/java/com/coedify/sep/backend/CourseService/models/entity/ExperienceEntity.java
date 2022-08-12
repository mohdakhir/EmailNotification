package com.coedify.sep.backend.CourseService.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Table(name = "experience")
@Entity
public class ExperienceEntity extends BaseEntity {

    @Column(name = "company_name")
    private String comapanyName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name= "skill_set")
    private String skillSet;

    @Column(name= "staff_id")
    private Long staffid;

}
