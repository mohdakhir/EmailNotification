package com.coedify.sep.backend.CourseService.models.pojo;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Reply extends Base {
    
   

    private Long postId;

    private String replyText;
    @NotNull(message = "Please provide your userId")
    private String userId;

    
    
}
