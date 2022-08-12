package com.coedify.sep.backend.CourseService.models.pojo;

import javax.validation.constraints.NotNull;

import com.coedify.sep.backend.CourseService.models.dto.response.StaffResponse;
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
public class StaffType extends Base {

    @NotNull(message = "Staff type is mandatory")
    private String staffType;
}
