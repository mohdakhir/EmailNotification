package com.coedify.sep.backend.NotificationService.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="contact_entity")
public class ContactEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String title;
    private Long contactTypeId;
    private String companyName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String pin;
    private String country;
    private String mobileNumber;
    private String businessPhone;
    private Long companyId;
    private boolean obsolete;
}
