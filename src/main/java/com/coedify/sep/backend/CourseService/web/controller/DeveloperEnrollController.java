package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffEnrollmentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffEnrollmentResponse;
import com.coedify.sep.backend.CourseService.services.ProgressService;
import com.coedify.sep.backend.CourseService.services.StaffEnrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class DeveloperEnrollController {

    @Autowired
    StaffEnrollService dEnrollService;

    @Autowired 
    ProgressService progressService;

    

    @PostMapping(value="/enroll")
    StaffEnrollmentResponse saveDevEnroll(@RequestBody StaffEnrollmentRequest request ){

        return dEnrollService.createDevEnroll(request);
    }

    @GetMapping(value="/enroll/{enrollId}")
    StaffEnrollmentResponse getDevEnroll(@PathVariable("enrollId") Long id){

        return dEnrollService.getDevEnroll(id);

    }

    @GetMapping(value="/enroll")
    List<StaffEnrollmentResponse> getAllEnrolls(){

        return dEnrollService.getAllDevEnrolled();
    }

    @PutMapping(value="/enroll/{devId}")
    StaffEnrollmentResponse updateEnrolledDev(@RequestBody StaffEnrollmentRequest enrollRequest,@PathVariable("devId") Long enrollId){


        return dEnrollService.updateEnrollDev(enrollRequest,enrollId);
    }

    // Method to get all enrolled courses of a developer
    @GetMapping("/developer/{id}/Courses")
    public List<CourseResponse> getAllEnrolledCourses(@PathVariable Long id){
        return dEnrollService.getAllEnrolledCourses(id);
    }

    
    
}
