package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.LikesRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.LikesResponse;
import com.coedify.sep.backend.CourseService.models.entity.LikesEntity;

public class LikesConverter {
    
    public static LikesResponse entityToResponse(LikesEntity entity){

        LikesResponse response = new LikesResponse();
        response.setId(entity.getId());
        response.setReplyId(entity.getReplyId());
        response.setUserId(entity.getUserId());

        return response;
    }

    public static LikesEntity requestToEntity(LikesRequest request){

        LikesEntity entity = new LikesEntity();
        entity.setId(request.getId());
        entity.setReplyId(request.getReplyId());
        entity.setUserId(request.getUserId());

        return entity;
    }

    public static List<LikesResponse> listOfLikesEntityToLikesResponse(List<LikesEntity> listOfEntities ){
        
        List<LikesResponse> listOfResponse = new ArrayList<>();
        listOfEntities.forEach(entity->
        listOfResponse.add(entityToResponse(entity))
        );

        return listOfResponse;
    }
}
