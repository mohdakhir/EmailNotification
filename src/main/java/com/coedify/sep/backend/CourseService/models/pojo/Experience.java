package com.coedify.sep.backend.CourseService.models.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Experience extends Base {
    @NotBlank(message = "CompanyName is mandatory")
    private String comapanyName;
    @NotBlank(message = "Designation is mandatory")
    private String designation;
    @NotBlank(message = "Start Date is mandatory")
    private String startDate;
    @NotBlank(message = "End Date is mandatory")
    private String endDate;
    @NotBlank(message = "SkillSet is mandatory")
    private String skillSet;
    @NotNull(message = "Please provide your staffId")
    private Long staffid;

}
