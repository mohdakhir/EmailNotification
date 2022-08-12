package com.coedify.sep.backend.CourseService.models.dto.request;



import java.util.List;

import com.coedify.sep.backend.CourseService.models.pojo.Module;

import lombok.Data;

@Data
public class ModuleRequest extends Module { 
    List<Long> topicList;
}
