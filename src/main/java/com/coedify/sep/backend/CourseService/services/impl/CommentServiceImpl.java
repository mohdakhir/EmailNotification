package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.converter.CommentConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.CommentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.CommentResponse;
import com.coedify.sep.backend.CourseService.models.entity.CommentEntity;
import com.coedify.sep.backend.CourseService.models.repository.CommentRepository;
import com.coedify.sep.backend.CourseService.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    // save api
    public CommentResponse saveCommentRequest(CommentRequest request) {
        log.info("Saving Comment");
        return CommentConverter.entityToResponse(commentRepository.save(CommentConverter.requestToEntity(request)));
    }

    public List<CommentResponse> getAllComments() {
        log.info("Fetching Comments");
        return CommentConverter.listOfCommentEntityToCommentResponse(commentRepository.findAll());
    }

    public CommentResponse deleCommentResponse(Long id) {
        log.info("Deleting comment by id", id);
        commentRepository.deleteById(id);
        return null;
    }

    @Override
    public CommentResponse updateCommentResponse(Long id, CommentRequest request) {
        CommentEntity entity = commentRepository.getById(id);
        entity.setCommentText(request.getCommentText());
        log.info("Updating Comment text ");
        return CommentConverter.entityToResponse(commentRepository.save(entity));
    }

    @Override
    public List<CommentResponse> getAllCommentsOnReplyId(Long replyId) {
        // log.info("fetching all comments by reply id", replyId);
        // List<CommentEntity> list = new ArrayList<>();
        // list.forEach(value->{
        // Optional<CommentEntity> entity= commentRepository.findById(replyId);

        // list.add(entity.get());
        // });

        // return CommentConverter.listOfCommentEntityToCommentResponse(list);

        return CommentConverter.listOfCommentEntityToCommentResponse(commentRepository.noOfCommentsOnReply(replyId));
    }

    @Override
    public void deleteCommentsByReplyId(Long replyId) {
        commentRepository.deleteAllByReplyId(replyId);
    }

    @Override
    public CommentResponse getComment(Long id) {

        if (commentRepository.existsById(id)) {
            CommentEntity entity = commentRepository.getById(id);

            return CommentConverter.entityToResponse(entity);
        } else {
            log.error("comment Id does not exist", id);

        }

        CommentEntity entity = commentRepository.getById(id);
        return CommentConverter.entityToResponse(entity);

    }
}
