package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.TopicRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.TopicResponse;
import com.coedify.sep.backend.CourseService.models.entity.TopicEntity;



public class TopicConverter {
    

       public static TopicEntity requestToEntity(TopicRequest topicRequest){

         TopicEntity topicEntity = new TopicEntity();

         topicEntity.setId(topicRequest.getId());
         topicEntity.setName(topicRequest.getName());
         topicEntity.setDescription(topicRequest.getDescription());
         topicEntity.setTopicType(topicRequest.getTopicType());
         topicEntity.setWeightage(topicRequest.getWeightage());
          
         return topicEntity;
          }

   public static TopicResponse entityToResponse(TopicEntity topicEntity){
        TopicResponse topicResponse = new TopicResponse();

         topicResponse.setId(topicEntity.getId());
         topicResponse.setName(topicEntity.getName());
         topicResponse.setDescription(topicEntity.getDescription());
         topicResponse.setTopicType(topicEntity.getTopicType());
         topicResponse.setWeightage(topicEntity.getWeightage());
        
        return topicResponse;
    }


    public static List<TopicResponse> entityListToResponseList(List<TopicEntity> list){

      List<TopicResponse> responseList = new LinkedList<>();

      list.forEach(value->{
        
        responseList.add(entityToResponse(value));

      

      });

      return responseList;
    }

    public static List<TopicEntity> requestListToEntityList(List<TopicRequest> list){

      List<TopicEntity> entityList = new LinkedList<>();

      list.forEach(value->{
        
        entityList.add(requestToEntity(value));

      

      });

      return entityList;
    }




}
