package com.coedify.sep.backend.CourseService.models.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data

public class ModuleTopic{
    private List<Long> topicId;
    private Long moduleId;
}
