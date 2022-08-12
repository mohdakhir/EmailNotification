package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.LikesRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.LikesResponse;
import com.coedify.sep.backend.CourseService.models.repository.LikesRepository;
import com.coedify.sep.backend.CourseService.services.LikesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LikesController
{
    @Autowired
    LikesService likesService;

    @PostMapping("/like")
    LikesResponse saveLikes(@RequestBody LikesRequest request){

        return likesService.saveLikes(request);
    }

    @GetMapping("/likes")
    List<LikesResponse> getAllLikes(){

        List<LikesResponse> response = likesService.getAllLikes();

        return response;
    }

    @GetMapping("/likes/{replyId}")
    List<LikesResponse> getLikesByReplyId(@PathVariable("replyId") Long replyId)
    {
        List<LikesResponse> response = likesService.getLikesByReplyId(replyId);

        return response;
    }
  
}
