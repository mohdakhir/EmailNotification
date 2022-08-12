package com.coedify.sep.backend.CourseService.models.dto.request;


import java.util.List;

import com.coedify.sep.backend.CourseService.models.pojo.Course;

import lombok.Data;

@Data
public class CourseRequest extends Course{
    List<Long> moduleList;
}
