package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffEnrollmentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffEnrollmentResponse;

public interface StaffEnrollService  {

   public StaffEnrollmentResponse createDevEnroll(StaffEnrollmentRequest request);

   public StaffEnrollmentResponse getDevEnroll(Long requestId);

   public List<StaffEnrollmentResponse> getAllDevEnrolled();


   public StaffEnrollmentResponse updateEnrollDev(StaffEnrollmentRequest enrollRequest, Long enrollId);

   public List<CourseResponse> getAllEnrolledCourses(Long developerId);

    
}
