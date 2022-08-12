package com.coedify.sep.backend.CourseService.models.repository;

import com.coedify.sep.backend.CourseService.models.entity.QualificationCourseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationCourseRepository extends JpaRepository<QualificationCourseEntity,Long>{
  
}
