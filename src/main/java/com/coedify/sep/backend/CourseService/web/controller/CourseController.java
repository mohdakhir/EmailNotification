package com.coedify.sep.backend.CourseService.web.controller;

import com.coedify.sep.backend.CourseService.commons.APIResponse;
import com.coedify.sep.backend.CourseService.models.dto.request.CourseRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class CourseController {

    @Autowired
    CourseService courseService;
    

    @GetMapping("/course/{courseId}")
    CourseResponse getCourseStructure(@PathVariable Long courseId)
    {
        return courseService.getCourseStructure(courseId);
    }

    @GetMapping("/course")
    APIResponse getAllCourseStructures(){
        return courseService.getAllCourseStructures();
    }

    @PostMapping("/course")
    CourseResponse createACourse(@RequestBody CourseRequest request){
        return courseService.createACourse(request);
    }
    
    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

    @PutMapping("/course/{courseId}")
    public CourseResponse updateCourse(@RequestBody CourseRequest request,@PathVariable Long courseId){
        return courseService.updateACourse(courseId, request);
    }
}
