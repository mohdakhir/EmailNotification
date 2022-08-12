package com.coedify.sep.backend.CourseService.services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.coedify.sep.backend.CourseService.commons.converter.TopicConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.TopicRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.TopicResponse;
import com.coedify.sep.backend.CourseService.models.entity.TopicEntity;
import com.coedify.sep.backend.CourseService.models.repository.TopicRepository;
import com.coedify.sep.backend.CourseService.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired 
    TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository2) {
        this.topicRepository=topicRepository2;
    }

    @Override
    public TopicResponse insertTopic(TopicRequest topicRequest){
       
        return TopicConverter.entityToResponse(topicRepository.save(TopicConverter.requestToEntity(topicRequest)));
    }

    @Override
    public TopicResponse updateTopic(TopicRequest topicRequest, long topicId){
        

     Optional<TopicEntity> topicEntity = topicRepository.findById(topicId);

        

        topicEntity.get().setName(topicRequest.getName());
        topicEntity.get().setDescription(topicRequest.getDescription());
        topicEntity.get().setTopicType(topicRequest.getTopicType());
        

         return TopicConverter.entityToResponse(topicRepository.save(topicEntity.get()));
    }

    @Override
   public TopicResponse getTopic(long topicId){
         
    

         Optional<TopicEntity> entity = topicRepository.findById(topicId);

         return TopicConverter.entityToResponse(entity.get());
    }

    @Override
     public List<TopicResponse> getAllTopics(){
        
       List<TopicResponse> list = new LinkedList<>();

        List<TopicEntity> topicEntities = topicRepository.findAll();

        topicEntities.forEach(value->{
            list.add(TopicConverter.entityToResponse(value));

        });
       
        return list;
  }

    @Override
    public void deleteTopic(Long topicId) {
        // TODO Auto-generated method stub
        
    }
}
