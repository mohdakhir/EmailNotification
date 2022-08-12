package com.coedify.sep.backend.CourseService.exception;

import com.coedify.sep.backend.CourseService.models.dto.response.ExceptionHandlerResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TopicAlreadyExistExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionHandlerResponse> handleException(TopicIdAlreadyExist topicIdAlreadyExist){

        // create StudentErrorResponse

        ExceptionHandlerResponse error = new ExceptionHandlerResponse();
        
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(topicIdAlreadyExist.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<ExceptionHandlerResponse>(error, HttpStatus.BAD_REQUEST);

    }
}
