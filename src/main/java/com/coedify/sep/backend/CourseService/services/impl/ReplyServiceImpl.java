package com.coedify.sep.backend.CourseService.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.commons.converter.ReplyConverter;
import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.CourseService.models.dto.request.ReplyRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CommentResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.LikesResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.ReplyResponse;
import com.coedify.sep.backend.CourseService.models.entity.ReplyEntity;
import com.coedify.sep.backend.CourseService.models.repository.CommentRepository;
import com.coedify.sep.backend.CourseService.models.repository.LikesRepository;
import com.coedify.sep.backend.CourseService.models.repository.ReplyRepository;
import com.coedify.sep.backend.CourseService.services.CommentService;
import com.coedify.sep.backend.CourseService.services.LikesService;
import com.coedify.sep.backend.CourseService.services.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private LikesService likesService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;

    // Create A Reply.
    @Override
    public ReplyResponse saveReply(ReplyRequest request) {

        ReplyResponse response =

                ReplyConverter.entityToResponse(replyRepository.save(ReplyConverter.requestToEntity(request)));
        log.info("Saved reply");
        return response;
    }

    // Get A Reply By Its Id.
    @Override
    public ReplyResponse getReplyById(Long id) {
        if (!replyRepository.existsById(id)) {
            throw new AssetNotFoundException("Reply Id Does Not Exists :" + id);
        }
        log.info("fetching reply by id");
        return ReplyConverter.entityToResponse(replyRepository.getById(id));
    }

    // Get All Replies.
    @Override
    public List<ReplyResponse> getAllReplies() {
        log.info("fetching all replies");
        return ReplyConverter.listOfEntityToResponse(replyRepository.findAll());

    }

    // Get A Reply with Likes And Comments By ReplyId.(Nested)
    @Override
    public ReplyResponse getReplyWithLikesComments(Long replyId) {
        ReplyResponse response = getReplyById(replyId);
        log.info("fetching likes for reply id in likes table", replyId);
        List<LikesResponse> listOfLikes = likesService.getLikesByReplyId(replyId);

        List<CommentResponse> listOfComments = commentService.getAllCommentsOnReplyId(replyId);
        response.setComments(listOfComments);
        response.setLikes(listOfLikes);
        return response;
    }

    // Get A Reply with Comments By ReplyId.(Nested)
    @Override
    public ReplyResponse getAllCommentsByReplyId(Long replyId) {
        ReplyResponse response = getReplyById(replyId);
       //log.info("fetching comments for this reply id ", replyId);
       //List<CommentResponse> listOfComments = commentService.getAllCommentsOnReplyId(replyId);
       // response.setComments(listOfComments);
       // return response;
       List<CommentResponse> listOfComments=commentService.getAllCommentsOnReplyId(replyId);
        response.setComments(listOfComments);
       return response;
    }

    // Get Replies with likes and Comments By postId.(Nested)
    @Override
    public List<ReplyResponse> getAllRepliesWithLikeComment(Long postId) {

        List<ReplyResponse> listofreplies = getAllRepliesByPostId(postId);

        List<ReplyResponse> list = new ArrayList<>();

        try {
            listofreplies.forEach(reply -> {
                ReplyResponse replywithlikecomment = getReplyWithLikesComments(reply.getId());

                list.add(replywithlikecomment);
            });
        }

        catch (NullPointerException e) {
            System.out.println("Null pointer");
        }

        return list;
    }

    // Get All Replies By PostId.
    @Override
    public List<ReplyResponse> getAllRepliesByPostId(Long postId) {

        log.info("fetching replies by postId");
        return ReplyConverter.listOfEntityToResponse(replyRepository.findAllByPostId(postId));
    }

    // Delete Reply With Likes And Comments.
    @Override
    @Transactional
    public void deleteReplyWithLikesAndComments(Long replyId) {
        if (likesRepository.existsLikesByReplyId(replyId)) {

            log.error("reply id doesn't exist in likes table", replyId);
            likesRepository.deleteAllByReplyId(replyId);
            log.info("likes deleted for replyId", replyId);
        }
        if (commentRepository.existsCommentByReplyId(replyId)) {

            log.error("reply id doesn't exist in comment table", replyId);
            commentRepository.deleteAllByReplyId(replyId);
            log.info("comment deleted for replyId", replyId);
        }

        replyRepository.deleteById(replyId);
        log.info("reply deleted", replyId);

    }
}
