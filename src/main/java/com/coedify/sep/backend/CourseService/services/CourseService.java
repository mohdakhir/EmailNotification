package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.APIResponse;
import com.coedify.sep.backend.CourseService.models.dto.request.CourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;


public interface CourseService {
    public CourseResponse saveACourse(CourseRequest courseRequest);
    public CourseResponse getCourse(Long courseId);
    public CourseResponse getCourseStructure(Long courseId);
    public List<CourseResponse> getAllCourses();
    public APIResponse getAllCourseStructures();
    public CourseResponse createACourse(CourseRequest request);
    public void deleteCourse(Long id);
    public CourseResponse updateACourse(Long courseId,CourseRequest request);
}
