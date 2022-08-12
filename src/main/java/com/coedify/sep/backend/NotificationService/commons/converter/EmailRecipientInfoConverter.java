package com.coedify.sep.backend.NotificationService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailRecipientInfoRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailRecipientInfoResponse;
import com.coedify.sep.backend.NotificationService.models.entity.EmailRecipientInfoEntity;

public class EmailRecipientInfoConverter {
    
    public static EmailRecipientInfoEntity requestToEntity(EmailRecipientInfoRequest request){
        EmailRecipientInfoEntity entity = new EmailRecipientInfoEntity();
        entity.setCreatedDate(request.getCreatedDate());
        entity.setDescription(request.getDescription());
        entity.setId(request.getId());
        entity.setUpdatedDate(request.getUpdatedDate());
        entity.setObsolete(request.getObsolete());
        entity.setName(request.getName());
        return entity;
    }

    public static EmailRecipientInfoResponse entityToResponse(EmailRecipientInfoEntity entity){
        EmailRecipientInfoResponse response=new EmailRecipientInfoResponse();
        response.setCreatedDate(entity.getCreatedDate());
        response.setDescription(entity.getDescription());
        response.setId(entity.getId());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setObsolete(entity.getObsolete());
        response.setName(entity.getName());
        return response;  
    }

    public static List<EmailRecipientInfoResponse> listOfEmailRecipientInfoEntityToResponse(List<EmailRecipientInfoEntity> entities){
        List<EmailRecipientInfoResponse> listOfResponses = new ArrayList<>();
        entities.forEach(entity->{
            listOfResponses.add(entityToResponse(entity));
        });
        return listOfResponses;
    }

    public static List<EmailRecipientInfoEntity> listOfEmailRecipientInfoRequestToEntity(List<EmailRecipientInfoRequest> requests){
        List<EmailRecipientInfoEntity> listOfEntity=new ArrayList<>();
        requests.forEach(request->{
            listOfEntity.add(requestToEntity(request));
        });
        return listOfEntity;
    }
    
}
