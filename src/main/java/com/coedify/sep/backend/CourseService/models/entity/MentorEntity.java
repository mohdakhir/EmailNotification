package com.coedify.sep.backend.CourseService.models.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "mentors")
@Data
public class MentorEntity  extends BaseEntity{
    @Column(name="name")
    private String name;

    @Column(name="skypeId",unique=true)
    private String skypeId;

    @Column(name="contact",unique=true)
    private String contact;


}
