package com.coedify.sep.backend.NotificationService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="contactType_entity")
public class ContactTypeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
    @Column(name="contactType")
   private String contactType;
}
