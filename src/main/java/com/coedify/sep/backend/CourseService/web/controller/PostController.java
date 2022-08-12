package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.coedify.sep.backend.CourseService.commons.PostErrorResponse;
import com.coedify.sep.backend.CourseService.models.dto.request.PostRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.BaseApiResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.PostResponse;
import com.coedify.sep.backend.CourseService.models.repository.PostRepository;
import com.coedify.sep.backend.CourseService.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class PostController {

  @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;
    
    @PostMapping("/post")
    public PostResponse savePost(@Valid @RequestBody PostRequest request) {
      return postService.savePost(request);
    }

    //Get Post by post Id(Post,replies,likes,comment)
    @GetMapping("/post/{id}")
    public PostResponse getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    
    //Getting records from only PostEntity
    @GetMapping("/post")
    public List<PostResponse> getAllPost() {
      return postService.getAllPost();
    }
    
    
    // Api for getting ALL NESTED data(post,replies,comment,likes)
    @GetMapping("/post/replies")
    public List<PostResponse> FetchAllPostWithReplies(){
        return postService.getAllPostWithReplies();
    }

    //Get  Return list of post by using courseModuleId an associated replies, comments, and likes.
    @GetMapping("/posts/moduleId/{id}")
    public List<PostResponse> getAllPostByCourseModuleId(@PathVariable Long id){
      return postService.getAllPostByModuleId(id);
    }

    @PutMapping("/post/{id}")
    public PostResponse updatePostResponse(@PathVariable Long id, @RequestBody PostRequest request) {
      return postService.updatePostResponse(id, request);
    }
    

    // @DeleteMapping("/post/{id}")
    // public PostResponse deleteEntity(@PathVariable Long id){
    //   return postService.deletePostResponse(id);
    // }

    @DeleteMapping("post/replyLikesComments/{id}")
    public void deletePostWithRespectToReply(@PathVariable Long id) {
      postService.deletePostWithRepliesCommentsAndLikes(id);
    }
    
    

 
}
