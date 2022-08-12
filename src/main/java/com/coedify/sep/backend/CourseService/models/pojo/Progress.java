package com.coedify.sep.backend.CourseService.models.pojo;

import java.time.Instant;

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
public class Progress extends Base{
  
    private Long enrollmentId;
    private Long topicId;
    private Long moduleId;
    private Instant startDate;
    private Instant endDate;
    private Boolean requestSent=false;

}
