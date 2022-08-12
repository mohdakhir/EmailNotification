package com.coedify.sep.backend.CourseService.models.repository;

import java.util.Optional;

import com.coedify.sep.backend.CourseService.models.entity.ModuleMentorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleMentorRepository extends JpaRepository<ModuleMentorEntity , Long>{
    void deleteAllByModuleId(Long moduleId);

    void deleteAllByMentorId(Long id);
    
}
