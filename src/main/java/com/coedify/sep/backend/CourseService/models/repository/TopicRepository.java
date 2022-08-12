package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.TopicEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TopicRepository extends JpaRepository<TopicEntity,Long>{

    @Query(value = "select tp.* from topics tp left Join module_topic mt On tp.id = mt.topic_id where mt.module_id=:mId order by mt.topic_order",nativeQuery = true)
    List<TopicEntity> getAllTopics(@Param("mId") Long moduleId);
     
}
