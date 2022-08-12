package com.coedify.sep.backend.CourseService.models.repository;

import com.coedify.sep.backend.CourseService.models.entity.QualificationTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationTypeRepository extends JpaRepository<QualificationTypeEntity,Long>{
  
}
