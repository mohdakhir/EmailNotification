package com.coedify.sep.backend.CourseService.models.pojo;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Mentor extends Base {
    
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Enter a valid email address")
    @NotBlank
    private String skypeId;
    
    @Pattern(regexp = "(^[0-9]{10}$)", message = "Mobile Number not valid")
    @NotBlank
    private String contact;
}
