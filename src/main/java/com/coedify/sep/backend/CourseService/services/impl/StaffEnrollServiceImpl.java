package com.coedify.sep.backend.CourseService.services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.coedify.sep.backend.CourseService.commons.converter.CourseConverter;
import com.coedify.sep.backend.CourseService.commons.converter.StaffEnrollmentConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.StaffEnrollmentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CourseResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffEnrollmentResponse;
import com.coedify.sep.backend.CourseService.models.entity.CourseEntity;
import com.coedify.sep.backend.CourseService.models.entity.StaffEnrollmentEntity;
import com.coedify.sep.backend.CourseService.models.repository.DeveloperEnrollmentRepository;
import com.coedify.sep.backend.CourseService.services.StaffEnrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StaffEnrollServiceImpl implements StaffEnrollService {

    @Autowired
    DeveloperEnrollmentRepository dRepository;

    @Override
    public StaffEnrollmentResponse createDevEnroll(StaffEnrollmentRequest request) {
        
        log.info("saving developer enroll");
      return StaffEnrollmentConverter.entityToResponse(dRepository.save( StaffEnrollmentConverter.requestToEntity(request)));

        
    }

    @Override
    public StaffEnrollmentResponse getDevEnroll(Long requestId) {
        log.info("fetching developer enroll by id",requestId);
        return StaffEnrollmentConverter.entityToResponse(dRepository.findById(requestId).get());
        
    }

    @Override
    public List<StaffEnrollmentResponse> getAllDevEnrolled() {
        log.info("fetching developers enrolls");
        return StaffEnrollmentConverter.entityListToResopnseList(dRepository.findAll());
    }

    @Override
    public StaffEnrollmentResponse updateEnrollDev(StaffEnrollmentRequest enrollRequest, Long enrollId) {
        
        Optional<StaffEnrollmentEntity> entity = dRepository.findById(enrollId);
        entity.get().setCourseId(enrollRequest.getCourseId());
        entity.get().setStaffId(enrollRequest.getStaffId());
        log.info("update developer enrollment");
        return StaffEnrollmentConverter.entityToResponse(dRepository.save(entity.get()) );
    }

    @Override
    public List<CourseResponse> getAllEnrolledCourses(Long developerId) {
                                  
        List<CourseEntity> courseEntities = dRepository.getAllEnrolledCourses(developerId);

        List<CourseResponse> list = new LinkedList<>();

        courseEntities.forEach(value->{

            list.add(CourseConverter.entityToResponse(value));
        });
         
        return list;

    }
    
}
