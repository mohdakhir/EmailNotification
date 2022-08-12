package com.coedify.sep.backend.CourseService.models.pojo;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)

public class Course extends Base{
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "Description is mandatory")
    private String courseDescription;
}
    

