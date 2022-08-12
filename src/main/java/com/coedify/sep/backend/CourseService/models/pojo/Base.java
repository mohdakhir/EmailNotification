package com.coedify.sep.backend.CourseService.models.pojo;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Base {
    private long id;
    private String createdBy;
    private Instant createdDate;
    private String updatedBy;
    private Instant updatedDate;

}
