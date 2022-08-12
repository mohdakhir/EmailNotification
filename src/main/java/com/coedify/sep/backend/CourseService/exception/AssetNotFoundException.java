package com.coedify.sep.backend.CourseService.exception;

public class AssetNotFoundException extends RuntimeException{

    public AssetNotFoundException(String message) {
        super(message);
    }

    public AssetNotFoundException(Throwable cause) {
        super(cause);
    }

    public AssetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
