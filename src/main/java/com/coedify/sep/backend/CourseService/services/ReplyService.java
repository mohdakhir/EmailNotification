package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ReplyRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ReplyResponse;

public interface ReplyService {

    public ReplyResponse getReplyById(Long replyId);
    public List<ReplyResponse> getAllReplies();
    public ReplyResponse saveReply(ReplyRequest request ); 
    public void deleteReplyWithLikesAndComments(Long replyId);
    public ReplyResponse getReplyWithLikesComments(Long id);
    public ReplyResponse getAllCommentsByReplyId(Long replyId);
    public List<ReplyResponse> getAllRepliesByPostId(Long postId);
    public List<ReplyResponse> getAllRepliesWithLikeComment(Long postId);
}
