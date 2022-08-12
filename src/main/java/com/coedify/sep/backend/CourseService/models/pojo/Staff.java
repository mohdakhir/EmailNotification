package com.coedify.sep.backend.CourseService.models.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.coedify.sep.backend.CourseService.models.entity.StaffTypeEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Staff extends Base {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "email is mandatory")
    @Email(message = "Enter a valid email")
    private String email;

    @Pattern(regexp = "(^[0-9]{10}$)", message = "Mobile Number not valid")
    @NotBlank(message = "Mobile number is mandatory")
    private Long mobileNumber;

    @NotNull(message = "Staff Type is mandatory")
    private Long staffTypeId;
}
