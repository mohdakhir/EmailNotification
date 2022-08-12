package com.coedify.sep.backend.NotificationService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="emailGroup_entity")
@Entity
public class EmailGroupEntity  extends BaseEntity{
    @Column(name="name",unique=true)
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="isObolete")
    private Boolean obsolete;
}
