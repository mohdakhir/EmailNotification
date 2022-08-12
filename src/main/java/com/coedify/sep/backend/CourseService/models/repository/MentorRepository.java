package com.coedify.sep.backend.CourseService.models.repository;

import com.coedify.sep.backend.CourseService.models.entity.MentorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<MentorEntity, Long>{

    
}
