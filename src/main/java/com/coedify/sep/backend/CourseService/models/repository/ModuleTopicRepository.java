package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.ModuleTopicEntity;
import com.coedify.sep.backend.CourseService.models.entity.TopicEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuleTopicRepository extends JpaRepository<ModuleTopicEntity,Long>{

        
        // @Query("select tp from TopicEntity tp where tp.id in (select mt.topicId from ModuleTopicEntity mt where mt.moduleId=:mId)")
        // @Query("select tp from TopicEntity tp left join ModuleTopic Entity mt On tp.Id = mt.topicId where mt.moduleId=:mId order by mt.topic_order")
        // @Query(value = "select tp.* from topics tp left Join module_topic mt On tp.id = mt.topic_id where mt.module_id=:mId order by mt.topic_order",nativeQuery = true)
        // List<TopicEntity> getAllTopics(@Param("mId") Long moduleId);


        Long deleteByModuleId(Long moduleId);

        Long deleteByTopicId(Long topicId);

      
}
