package com.coedify.sep.backend.CourseService.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostErrorResponse {
  
  private int status;
  private String message;
  private Long TimeStamp;

}
