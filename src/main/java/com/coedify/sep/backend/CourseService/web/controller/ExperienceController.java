package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ExperienceRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ExperienceResponse;
import com.coedify.sep.backend.CourseService.services.ExperienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @PostMapping("/createExperience")
    public ExperienceResponse craeteExperience(@RequestBody ExperienceRequest request) {
        return experienceService.createExperience(request);
    }

    @PostMapping("/getExperienceById")
    public List<ExperienceResponse> getExperience(@RequestBody ExperienceRequest request) {
        return experienceService.getExperienceById(request.getStaffid());

    }

    
    @PostMapping("/getAllExperience")
    public List<ExperienceResponse> getAllExperience() {
        return experienceService.getAllxperience();
    }


    @PostMapping("/updateExperience")
    public List<ExperienceResponse> updateExperience(@RequestBody List<ExperienceRequest> request) {
        return experienceService.updateExperience(request);

    }

    @PostMapping("/deleteExperience")
    public void deleteExperience(@RequestBody ExperienceRequest request) {
        experienceService.deleteById(request.getStaffid());
    }

}
