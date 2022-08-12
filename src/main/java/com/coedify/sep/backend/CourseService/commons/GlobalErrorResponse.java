package com.coedify.sep.backend.CourseService.commons;

public class GlobalErrorResponse {

    private int status;
    private String message;
    private Long timeStamp;
    
    //no argument constructor
    public GlobalErrorResponse()
    {

    }

    //fields constructor
    public GlobalErrorResponse(int status,String message,Long timeStamp)
    {
        this.status=status;
        this.message=message;
        this.timeStamp=timeStamp;

    }

    //getters and setters
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)

    {
        this.status=status;

    }
    
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message=message;
    }
    
    public Long getTimeStamp()
    {
        return timeStamp;

    }

    public void setTimeStamp(Long timeStamp)
    {
        this.timeStamp=timeStamp;
    }


    

}
