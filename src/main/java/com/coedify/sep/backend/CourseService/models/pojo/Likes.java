package com.coedify.sep.backend.CourseService.models.pojo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Likes extends Base  {
    
    // Changed likesFor to replyId
    //yes likes for reply id
    private Long replyId;
    @NotNull(message = "Please provide your userId")
    private String userId;

}
