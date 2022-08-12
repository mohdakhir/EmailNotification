package com.coedify.sep.backend.CourseService.models.dto.response;



import java.util.List;

import com.coedify.sep.backend.CourseService.models.pojo.Course;

import lombok.Data;

@Data
public class CourseResponse extends Course{
    
    List<ModuleResponse> moduleList;
}
