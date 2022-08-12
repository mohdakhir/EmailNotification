package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ReplyRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ReplyResponse;
import com.coedify.sep.backend.CourseService.models.repository.ReplyRepository;
import com.coedify.sep.backend.CourseService.services.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ReplyController {

    @Autowired
    ReplyService replyService;
    @Autowired
    ReplyRepository replyRepository;

    // Create a Reply.
    @PostMapping("/reply")
    ReplyResponse saveReply(@RequestBody ReplyRequest request) {
        System.out.println("Saved");
        return replyService.saveReply(request);
    }

    // Get a Reply By Its Id.
    @GetMapping("/reply/{id}")
    ReplyResponse getById(@PathVariable("id") Long replyId) {

        return replyService.getReplyById(replyId);

    }

    // Get all Replies.
    @GetMapping("/reply")
    List<ReplyResponse> getAllReplies() {

        return replyService.getAllReplies();
    }

    // Get Reply With Likes and Comments.
    @GetMapping("/reply/likecomment/{id}")
    ReplyResponse fetchLikesComments(@PathVariable("id") Long replyId) {

        return replyService.getReplyWithLikesComments(replyId);
    }

    // Get All Comments By ReplyId.                                          
    @GetMapping("/comment/{replyId}")
    ReplyResponse getAllCommentsByReplyId(@PathVariable Long replyId) {
        return replyService.getAllCommentsByReplyId(replyId);
    }

    // Get All Replies By PostId.
    @GetMapping("/replies/{postId}")
    List<ReplyResponse> getAllRepliesByPostId(@PathVariable Long postId) {
        return replyService.getAllRepliesByPostId(postId);
    }

    // Get All Replies By PostId.(Nested)(Post,Replies,Likes,Comments).
    @GetMapping("/repliesData/{postId}")
    List<ReplyResponse> getAllRepliesWithLikeComment(@PathVariable Long postId) {
        return replyService.getAllRepliesWithLikeComment(postId);
    }

    // Delete Reply with likes And Comments By reply id.
    @DeleteMapping("/reply/{replyId}")
    void deleteReply(@PathVariable Long replyId) {
        replyService.deleteReplyWithLikesAndComments(replyId);
    }

}
