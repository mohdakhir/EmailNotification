package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.APIResponse;
import com.coedify.sep.backend.CourseService.models.dto.request.ProgressRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ProgressResponse;
import com.coedify.sep.backend.CourseService.services.ProgressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProgressController {

    @Autowired
    ProgressService progressService;


    // api to save data in progress table
    @PostMapping("/progress")
    public ProgressResponse createProgress(@RequestBody ProgressRequest progressRequest){
        return progressService.createProgress(progressRequest);
    }
    
    // api to test count of topics covered by a developer
    @GetMapping("/topicsCovered/{enrollmentId}")
    Long topicsCovered(@PathVariable Long enrollmentId){
       return progressService.topicsCovered(enrollmentId);
    }

    @PostMapping("/isTopicsCompleted")
    Boolean isTopicCompleted(@RequestBody ProgressRequest progressRequest){
       return progressService.isTopicCompleted(progressRequest);
    }

    @GetMapping("/progress/{enrollmentId}")
    APIResponse getProgressByEnrollmentId(@PathVariable Long enrollmentId){
       return progressService.getProgressbyEnrollmentId(enrollmentId);
    }





}
