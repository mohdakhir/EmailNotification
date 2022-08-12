package com.coedify.sep.backend.NotificationService.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emailRecipientInfo_entity")
public class EmailRecipientInfoEntity extends BaseEntity{
    private String name;
    private String description;
    private Boolean obsolete;
}
