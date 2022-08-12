package com.coedify.sep.backend.NotificationService.models.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BaseApiResponse<T> {
    protected boolean error;
    protected String code;
    protected T data;
    protected String message;

    public static <R> BaseApiResponse<R> okResponse(R data) {
        return new BaseApiResponse<>(false, data, "200");
    }

    public BaseApiResponse(boolean error, T data, String code) {
        this.error = error;
        this.code = code;
        this.data = data;
    }

    public BaseApiResponse(boolean error, T data, String code, String message) {
        this.error = error;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseApiResponse() {

    }

}