package com.coedify.sep.backend.CourseService.commons;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class APIResponse {

    private Integer status;
    private Object error;
    private Object data;

    public APIResponse(Integer status, Object error, Object data){
        this.status=HttpStatus.OK.value();
        this.data = data;
        this.error = error;
    }
    public APIResponse(){

    }

    
}
