package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;
import java.util.Optional;

import com.coedify.sep.backend.CourseService.models.dto.response.PostResponse;
import com.coedify.sep.backend.CourseService.models.entity.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByModuleId( Long moduleId);








    
}
