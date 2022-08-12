package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.converter.LikesConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.LikesRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.LikesResponse;
import com.coedify.sep.backend.CourseService.models.repository.LikesRepository;
import com.coedify.sep.backend.CourseService.models.repository.ReplyRepository;
import com.coedify.sep.backend.CourseService.services.LikesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    ReplyRepository replyRepository;

    // Save likes for a post with post id
    @Override
    public LikesResponse saveLikes(LikesRequest request) {
        
        LikesResponse response =  LikesConverter.entityToResponse(likesRepository.save(LikesConverter.requestToEntity(request)));
       log.info("Saving likes");
        return response;
    }

    @Override
    public List<LikesResponse> getAllLikes() {
        log.info("fetching all likes");
        return LikesConverter.listOfLikesEntityToLikesResponse( likesRepository.findAll());
    }


    //Likes By ReplyId in replyServiceImpl
    @Override
    public List<LikesResponse> getLikesByReplyId(Long replyId) 
    {
        log.info("fetching likes by replyId");
        return LikesConverter.listOfLikesEntityToLikesResponse(likesRepository.noOfLikesForAReply(replyId));
    }
    
}
