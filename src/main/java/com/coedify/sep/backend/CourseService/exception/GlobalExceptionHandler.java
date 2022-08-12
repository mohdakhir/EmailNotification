package com.coedify.sep.backend.CourseService.exception;

import javax.servlet.http.HttpServletResponse;

import com.coedify.sep.backend.CourseService.commons.GlobalErrorResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.BaseApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  // write all exception handlers here
  // PostIdNotFound
  @ExceptionHandler(value = AssetNotFoundException.class)
  @ResponseBody
  public <T> BaseApiResponse<T> handleException(AssetNotFoundException exe) { // baseapiresponse use

    // create a postIdErrorResponse object
    // GlobalErrorResponse error = new GlobalErrorResponse();

    // error.setStatus(HttpStatus.NOT_FOUND.value());
    // error.setMessage(exe.getMessage());
    // error.setTimeStamp(System.currentTimeMillis());

    // return a Respo;nse Entity
    BaseApiResponse<T> baseApiResponse = new BaseApiResponse<T>(true, null,
        "1233",
        exe.getMessage());
    return baseApiResponse;

  }

  // replyIdNotFound
  /*
   * @ExceptionHandler
   * public ResponseEntity<GlobalErrorResponse>
   * handleException(ReplyIdNotFoundException exc) {
   * GlobalErrorResponse error = new GlobalErrorResponse();
   * error.setStatus(HttpStatus.NOT_FOUND.value());
   * error.setMessage(exc.getMessage());
   * error.setTimeStamp(System.currentTimeMillis());
   * 
   * return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
   * 
   * }
   */

  // Generic exception handler.

  @ExceptionHandler(value = Exception.class)
  @ResponseBody

  public <T> BaseApiResponse <T> handleException(Exception exception) { // HttpServletResponse response

    // response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    // response.setHeader("Status",
    // HttpStatus.INTERNAL_SERVER_ERROR.value() + " " +
    // HttpStatus.INTERNAL_SERVER_ERROR
    // .getReasonPhrase());
    BaseApiResponse<T> baseApiResponse = new BaseApiResponse<T>(true, null,
        "500",
        exception.getMessage());
    return baseApiResponse;
    /*
     * GlobalErrorResponse error = new GlobalErrorResponse();
     * error.setStatus(HttpStatus.BAD_REQUEST.value());
     * error.setMessage("Bad Data Request.."); //exc.get
     * // error.setMessage(exc.getMessage());
     * error.setTimeStamp(System.currentTimeMillis());
     * 
     * // return a Response Entity
     * return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     */

  }

}