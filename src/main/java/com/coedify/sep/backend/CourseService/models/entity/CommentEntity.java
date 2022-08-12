package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class CommentEntity extends BaseEntity{
    
    @Column(name="replyId")
    private Long replyId;

    @Column(name="postId")
    private Long postId;

    @Column(name="commentText")
    private String commentText;
    
    @Column(name="userId")
    private String userId;

}
