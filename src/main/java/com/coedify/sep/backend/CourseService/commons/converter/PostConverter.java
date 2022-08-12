package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.PostRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.PostResponse;
import com.coedify.sep.backend.CourseService.models.entity.PostEntity;

public class PostConverter {
    public static PostEntity requestToEntity(PostRequest request){
        PostEntity entity = new PostEntity();

        entity.setModuleId(request.getModuleId());
        entity.setPostBody(request.getPostBody());
        entity.setPostTitle(request.getPostTitle());
        entity.setId(request.getId());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setCreatedDate(request.getCreatedDate());
        entity.setUpdatedBy(request.getUpdatedBy());
        entity.setUpdatedDate(request.getUpdatedDate());
        entity.setUserId(request.getUserId());

        return entity;
    }

    public static PostResponse entityToResponse(PostEntity entity){
        PostResponse response =new PostResponse();
        
        response.setModuleId(entity.getModuleId());
        response.setPostBody(entity.getPostBody());
        response.setPostTitle(entity.getPostTitle());
        response.setId(entity.getId());
        response.setCreatedBy(entity.getCreatedBy());
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedBy(entity.getUpdatedBy());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setUserId(entity.getUserId());

        return response;
    }

    public static List<PostEntity> listOfRequestToEntity(List<PostRequest> request){
        List<PostEntity> entity = new LinkedList<>();

        request.forEach(value->{
            entity.add(requestToEntity(value));
        });

        return entity;
    }

    public static List<PostResponse> listOfEntityToResponse(List<PostEntity> entity){
        List<PostResponse> listOfResponse= new LinkedList<>();

        entity.forEach(value->{
            listOfResponse.add(entityToResponse(value));
        });

        return listOfResponse;
    }
        
}
