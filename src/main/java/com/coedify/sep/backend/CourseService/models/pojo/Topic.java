package com.coedify.sep.backend.CourseService.models.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.coedify.sep.backend.CourseService.commons.enums.TopicType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Topic extends Base {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private TopicType topicType;

    @NotNull
    private Integer weightage;

    
}
