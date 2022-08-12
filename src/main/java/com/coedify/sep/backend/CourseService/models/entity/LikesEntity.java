package com.coedify.sep.backend.CourseService.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "likes")
public class LikesEntity extends BaseEntity {

    @Column(name= "reply_id")
    @NotNull
    private Long replyId;

    @Column(name= "user_id")
    @NotNull
    private String userId;

    
}
