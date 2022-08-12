package com.coedify.sep.backend.CourseService.models.dto.response;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.pojo.Likes;
import com.coedify.sep.backend.CourseService.models.pojo.Reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReplyResponse extends Reply {
    

    private List<LikesResponse> likes;
    private List<CommentResponse> comments;


    
    
}
