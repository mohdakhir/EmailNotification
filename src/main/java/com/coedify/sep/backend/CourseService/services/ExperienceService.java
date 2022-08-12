package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ExperienceRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ExperienceResponse;

public interface ExperienceService {

    public ExperienceResponse createExperience(ExperienceRequest request);

    public  List<ExperienceResponse> getExperienceById(Long id);

    public List<ExperienceResponse> updateExperience(List<ExperienceRequest> request);

    public void deleteById(Long id);

    public  List<ExperienceResponse> getAllxperience();


    

}
