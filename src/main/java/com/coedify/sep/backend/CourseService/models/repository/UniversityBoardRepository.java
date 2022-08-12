package com.coedify.sep.backend.CourseService.models.repository;

import com.coedify.sep.backend.CourseService.models.entity.UniversityBoardEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityBoardRepository extends JpaRepository<UniversityBoardEntity,Long>{
  
}
