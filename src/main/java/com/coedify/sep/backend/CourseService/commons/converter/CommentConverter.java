package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.CommentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CommentResponse;
import com.coedify.sep.backend.CourseService.models.entity.CommentEntity;

public class CommentConverter {
    public static CommentEntity requestToEntity(CommentRequest request){
        CommentEntity entity = new CommentEntity();

        entity.setId(request.getId());
        entity.setPostId(request.getPostId());
        entity.setReplyId(request.getReplyId());
        entity.setCommentText(request.getCommentText());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setCreatedDate(request.getCreatedDate());
        entity.setUpdatedBy(request.getUpdatedBy());
        entity.setUpdatedDate(request.getUpdatedDate());
        entity.setUserId(request.getUserId());
        return entity;
    }

    public static CommentResponse entityToResponse(CommentEntity entity){
        CommentResponse response = new CommentResponse();
        response.setId(entity.getId());
        response.setReplyId(entity.getReplyId());
        response.setCommentText(entity.getCommentText());
        response.setCreatedBy(entity.getCreatedBy());
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedBy(entity.getUpdatedBy());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setUserId(entity.getUserId());
        response.setPostId(entity.getPostId());
        return response;
       
    }

    public static List<CommentResponse> listOfCommentEntityToCommentResponse(List<CommentEntity> entities){
        List<CommentResponse> listOfResponses = new LinkedList<>();

        entities.forEach(entity->{
            listOfResponses.add(entityToResponse(entity));
        });
        return listOfResponses;
    }

    public static List<CommentEntity> listOfRequestToEntity(List<CommentRequest> requests){
        List<CommentEntity> listOfEntity=new LinkedList<>();

        requests.forEach(request->{
            listOfEntity.add(requestToEntity(request));
        });
        return listOfEntity;
    }
}
