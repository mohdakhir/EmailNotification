package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.CommentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity , Long> {
   
    @Query(value = "select * from comment c where c.reply_id = ?1" , nativeQuery = true)
    List<CommentEntity> noOfCommentsOnReply(@Param("replyId") Long replyId);
    
    // @Modifying
    // @Query(value = "delete c.comment_for from comment c" , nativeQuery = true)
    // void deleteAllCommentsFromReplyId(@Param("id") Long id);


    boolean existsCommentByReplyId(Long replyId);

    void deleteAllByReplyId(Long replyId);
   
}
