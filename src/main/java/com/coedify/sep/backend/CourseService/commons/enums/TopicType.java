package com.coedify.sep.backend.CourseService.commons.enums;

public enum TopicType {
    TOPIC("Topic",1),
    ASSIGNMENT("Assignment",2),
    PROJECT("Project",3);

    String value;
    int code;

    TopicType(String value, int code){
        this.value = value;
        this.code = code;
    }
}
