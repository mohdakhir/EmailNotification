package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.CommentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CommentResponse;

public interface CommentService {

    CommentResponse saveCommentRequest(CommentRequest request);

    public List<CommentResponse> getAllComments();

    CommentResponse deleCommentResponse(Long id);

    public CommentResponse updateCommentResponse(Long id, CommentRequest request);

    public List<CommentResponse> getAllCommentsOnReplyId(Long replyId);

    public void deleteCommentsByReplyId(Long commentFor);

    public CommentResponse getComment(Long id);

}
