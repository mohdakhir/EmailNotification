package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.coedify.sep.backend.CourseService.models.dto.request.CommentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.BaseApiResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.CommentResponse;
import com.coedify.sep.backend.CourseService.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CommentController {
  @Autowired
  CommentService commentService;

  @PostMapping("/comment")
  public ResponseEntity<CommentResponse> saveCommentRequest(@Valid @RequestBody CommentRequest request) {

    return new ResponseEntity<>(commentService.saveCommentRequest(request), HttpStatus.CREATED);
  }

  // @GetMapping("/comment")
  // public List<CommentResponse> getAllResponses(){
  // return commentService.getAllComments();
  // }

  @GetMapping("/comment")
  public BaseApiResponse<?> getAllResponses() {

    return BaseApiResponse.okResponse(commentService.getAllComments());

  }

  @DeleteMapping("/comment/{id}")
  public CommentResponse deleCommentResponse(@PathVariable Long id) {
    return commentService.deleCommentResponse(id);
  }

  @PutMapping("comment/{id}")
  public CommentResponse updateCommentResponse(@PathVariable Long id, @RequestBody CommentRequest request) {
    return commentService.updateCommentResponse(id, request);
  }

  @GetMapping("comments/{replyId}")
  public List<CommentResponse> fetchCommentsByReplyId(@PathVariable Long replyId) {
    List<CommentResponse> response = commentService.getAllCommentsOnReplyId(replyId);
    return response;
  }

}
