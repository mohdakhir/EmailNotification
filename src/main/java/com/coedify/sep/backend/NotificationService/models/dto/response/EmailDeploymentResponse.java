package com.coedify.sep.backend.NotificationService.models.dto.response;

import java.util.List;

import com.coedify.sep.backend.NotificationService.models.pojo.EmailDeployment;

import lombok.Data;
@Data
public class EmailDeploymentResponse extends EmailDeployment {
    private  List<EmailRecipientInfoResponse> result;
    //public void setContactList(List<Long> contacts) {
    }
    

