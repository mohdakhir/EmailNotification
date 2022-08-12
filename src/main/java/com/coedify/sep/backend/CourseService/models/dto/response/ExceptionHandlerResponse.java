package com.coedify.sep.backend.CourseService.models.dto.response;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionHandlerResponse {
    private String message;
    private int status;
    private long timeStamp;

   
}
