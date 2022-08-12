package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.CourseModuleEntity;
import com.coedify.sep.backend.CourseService.models.entity.ModuleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseModuleRepository extends JpaRepository<CourseModuleEntity, Long> {
    @Query("select md from ModuleEntity md where md.id in (select cm.moduleId from CourseModuleEntity cm where cm.courseId=:cId)")
    List<ModuleEntity> getAllModules(@Param("cId") Long courseId );

    public void deleteByCourseId(Long courseId);

    void deleteByModuleId(Long moduleId);
}
