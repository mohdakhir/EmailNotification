package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.models.pojo.CourseModule;

public interface CourseModuleService {

    List<?> saveCourseModule(CourseModule request);
    public void deleteCourseStructure(Long courseId) ;
    public List<?> updateCourseStructure(CourseModule request);
    void deleteCourseStructureByModuleId(Long moduleId);
}
