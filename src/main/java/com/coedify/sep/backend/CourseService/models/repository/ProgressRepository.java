package com.coedify.sep.backend.CourseService.models.repository;

import java.time.Instant;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.ProgressEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProgressRepository extends JpaRepository<ProgressEntity, Long> {

    @Query("select count(*) from ProgressEntity pe where pe.endDate is NOT NULL and pe.enrollmentId=:eId")
    Long topicsCovered(@Param("eId") Long eId);

    @Query("select endDate from ProgressEntity pe where pe.topicId=:topicId and pe.enrollmentId=:eId and pe.moduleId=:moduleId")
    Instant getEndDateByUs(@Param("eId") Long eId, @Param("topicId") Long topicId, @Param("moduleId") Long moduleId);

    @Query("select id from ProgressEntity pe where pe.topicId=:topicId and pe.enrollmentId=:eId and pe.moduleId=:moduleId")
    Long getEntity(@Param("eId") Long eId, @Param("topicId") Long topicId, @Param("moduleId") Long moduleId);

    Boolean existsByEndDate(Instant endDate);

    List<ProgressEntity> findByEnrollmentId(Long enrollmentId);

}
