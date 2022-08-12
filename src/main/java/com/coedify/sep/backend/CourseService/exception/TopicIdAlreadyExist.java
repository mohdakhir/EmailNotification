package com.coedify.sep.backend.CourseService.exception;

public class TopicIdAlreadyExist  extends RuntimeException{

    public TopicIdAlreadyExist(String message) {
        super(message);
    }

    public TopicIdAlreadyExist(Throwable cause) {
        super(cause);
    }

    public TopicIdAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

   
    
}
