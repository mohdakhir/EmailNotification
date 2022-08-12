package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.CourseEntity;
import com.coedify.sep.backend.CourseService.models.entity.ModuleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long>{
    @Query("select md from ModuleEntity md where md.id in (select cm.moduleId from CourseModuleEntity cm where cm.courseId=:cId)")
    List<ModuleEntity> getAllModules(@Param("cId") Long courseId );


    
}
