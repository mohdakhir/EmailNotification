package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.APIResponse;
import com.coedify.sep.backend.CourseService.models.dto.request.ProgressRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ProgressResponse;

public interface ProgressService {

    
   public Long topicsCovered(Long enrollmentId);
  
  
   public Boolean isTopicCompleted(ProgressRequest progressRequest);

   public ProgressResponse createProgress(ProgressRequest progressRequest);

   
   public APIResponse getProgressbyEnrollmentId(Long enrollId);


}
