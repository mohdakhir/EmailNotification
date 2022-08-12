package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.CourseEntity;
import com.coedify.sep.backend.CourseService.models.entity.StaffEnrollmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeveloperEnrollmentRepository extends JpaRepository<StaffEnrollmentEntity, Long> {
    
    
    @Query("select ce from CourseEntity ce where ce.id in (select de.courseId from StaffEnrollmentEntity de where de.staffId=:dId)")
    List<CourseEntity> getAllEnrolledCourses(@Param("dId") Long developerId);
}
