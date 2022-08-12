package com.coedify.sep.backend.CourseService.models.pojo;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Comment extends Base {
    private Long replyId;
    private String commentText;
    @NotNull(message = "Please Provide Your UserId ")
    private String userId;
    private Long postId;
}
