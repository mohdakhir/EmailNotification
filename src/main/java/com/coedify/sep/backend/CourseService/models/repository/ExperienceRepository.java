package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.ExperienceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    
    void deleteAllByStaffid(@Param("sid") Long staffid);

    
    List<ExperienceEntity> findByStaffid(@Param("sid") Long staffid);

}


