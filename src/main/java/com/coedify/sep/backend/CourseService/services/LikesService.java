package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.LikesRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.LikesResponse;

public interface LikesService {
    
    LikesResponse saveLikes(LikesRequest request);
    List<LikesResponse> getAllLikes(); 
    List<LikesResponse> getLikesByReplyId(Long replyId);


}
