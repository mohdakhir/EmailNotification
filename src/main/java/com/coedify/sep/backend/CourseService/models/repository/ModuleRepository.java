package com.coedify.sep.backend.CourseService.models.repository;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.ModuleEntity;
import com.coedify.sep.backend.CourseService.models.entity.TopicEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity , Long> {
    
    @Query(value = "select md.* from modules md left Join course_module cm On md.id = cm.module_id where cm.course_id=:cId order by cm.module_order",nativeQuery = true)
    List<ModuleEntity> getAllModules(@Param("cId") Long courseId);
   
    
}
