package com.coedify.sep.backend.NotificationService.models.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact extends Base{
    @NotBlank
    @Size(min=2,message="name should have at least 2 characters")
    private String firstName;
    @NotBlank
    @Size(min=2,message="name should have at least 2 characters")
    private String lastName;
    @NotBlank//validation and format
    private String emailAddress;
    @NotBlank
    private String title;
    @NotNull
    private Long contactTypeId;
    @NotBlank
    @Size(min=5,message="name should have at least 5 characters")
    private String companyName;
    @NotBlank
    @Size(min=5,message="name should have at least 5 characters")
    private String address1;
    @NotBlank
    @Size(min=5,message="name should have at least 5 characters")
    private String address2;
    @NotBlank
    @Size(min=5,message="name should have at least 5 characters")
    private String city;
    @NotBlank
    @Size(min=2,message="name should have at least 5 characters")
    private String state;
    @NotNull//validate
    private String pin;
    @NotBlank
    @Size(min=5,message="name should have at least 5 characters")
    private String country;
    @NotNull//validate
    private String mobileNumber;
    @NotNull//validate
    private String businessPhone;
    @NotNull//validate
    private Long companyId;
    private boolean  obsolete;
}
