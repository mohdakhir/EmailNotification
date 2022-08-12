package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ReplyRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ReplyResponse;
import com.coedify.sep.backend.CourseService.models.entity.ReplyEntity;

public class ReplyConverter {


    public static ReplyEntity requestToEntity(ReplyRequest request){

        ReplyEntity entity = new ReplyEntity();
        entity.setId(request.getId());
       
        entity.setPostId(request.getPostId());
        entity.setUserId(request.getUserId());
        entity.setReplyText(request.getReplyText());
       
        return entity;
    }
  

    public static ReplyResponse entityToResponse(ReplyEntity entity){

        ReplyResponse response = new ReplyResponse();
        response.setId(entity.getId());
       
        response.setPostId(entity.getPostId());
        
        response.setUserId(entity.getUserId());
        response.setReplyText(entity.getReplyText());
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedDate(entity.getUpdatedDate());
        
        return response;
    }

   

    public static List<ReplyResponse> listOfEntityToResponse(List<ReplyEntity> listOfEntity){

        List<ReplyResponse> listOfResponse = new ArrayList<>();

        listOfEntity.forEach(entity -> {
          
        listOfResponse.add(entityToResponse(entity));
       
         } );

        return listOfResponse;

        }

       
    
}
