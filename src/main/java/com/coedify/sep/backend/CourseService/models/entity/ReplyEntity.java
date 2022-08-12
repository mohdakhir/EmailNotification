package com.coedify.sep.backend.CourseService.models.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coedify.sep.backend.CourseService.models.pojo.Likes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "reply")
public class ReplyEntity extends BaseEntity {

    private Long postId;

    private String replyText;

    private String userId;

    // @OneToMany(targetEntity = LikesEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name="likes_for")
    // private List<Likes> likes;
    // //,referencedColumnName = "id"

}
