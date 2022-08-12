package com.coedify.sep.backend.CourseService.models.dto.response;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.pojo.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PostResponse extends Post{

    private List<ReplyResponse> replies;

    private List<CommentResponse> comment;

    private List<LikesResponse> likes;

}
