package com.coedify.sep.backend.NotificationService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailRecipientInfoContactMapRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailRecipientInfoContactMapResponse;
import com.coedify.sep.backend.NotificationService.models.entity.EmailRecipientInfoContactMapEntity;

public class EmailRecipientInfoContactMapConverter {
    
   public static EmailRecipientInfoContactMapEntity requestToEntity(EmailRecipientInfoContactMapRequest request){
    EmailRecipientInfoContactMapEntity entity =new EmailRecipientInfoContactMapEntity();
      entity.setEmailRecipientInfoId(request.getEmailRecipientInfoId());
      entity.setContactId(request.getContactId());
        return entity;
        
    }
    public static EmailRecipientInfoContactMapResponse entityToResponse(EmailRecipientInfoContactMapEntity mapEntity){
        EmailRecipientInfoContactMapResponse  response =new EmailRecipientInfoContactMapResponse ();
        response.setEmailRecipientInfoId(mapEntity.getEmailRecipientInfoId());
        response.setContactId(mapEntity.getContactId());
        return response;
    }

   public static List<EmailRecipientInfoContactMapEntity> listOfrequestToEntity(List<EmailRecipientInfoContactMapRequest> listOfrequest){

        List<EmailRecipientInfoContactMapEntity> listOfEntity = new ArrayList<>();
        listOfrequest.forEach(request->{
            listOfEntity.add(requestToEntity(request));
        });
        return listOfEntity;
    }

    public static List<EmailRecipientInfoContactMapResponse> listOfEntityToResponse(List<EmailRecipientInfoContactMapEntity> listOfEntity){

        List<EmailRecipientInfoContactMapResponse> listOfResponse = new ArrayList<>();
        listOfEntity.forEach(entity->{
            listOfResponse.add(entityToResponse(entity));
        });
        return listOfResponse;
    }

}
