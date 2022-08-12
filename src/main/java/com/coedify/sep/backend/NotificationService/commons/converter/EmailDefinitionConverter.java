package com.coedify.sep.backend.NotificationService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDefinitionRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDefinitionResponse;
import com.coedify.sep.backend.NotificationService.models.entity.EmailDefinitionEntity;

public class EmailDefinitionConverter {
    public static EmailDefinitionEntity requestToEntity(EmailDefinitionRequest request){
        EmailDefinitionEntity  entity = new  EmailDefinitionEntity ();
        entity.setId(request.getId());
        entity.setEmailGroupId(request.getEmailGroupId());
        entity.setEmailName(request.getEmailName());
        entity.setHtmlEmail(request.getHtmlEmail());;
        entity.setSubjectLine(request.getSubjectLine());
        entity.setEmailContent(request.getEmailContent());
        entity.setFromAddress(request.getFromAddress());
        entity.setFromName(request.getFromName());
        entity.setCCAddress(request.getCCAddress());
        entity.setBCCAddress(request.getBCCAddress());
        entity.setCreatedDate(request.getCreatedDate());
        entity.setReplyToName(request.getReplyToName());
        entity.setReplyToAddress(request.getReplyToAddress());
        entity.setObsolete(request.getObsolete());
        entity.setUpdatedDate(request.getUpdatedDate());
        return entity;
    }

    public static EmailDefinitionResponse entityToResponse(EmailDefinitionEntity entity){
        EmailDefinitionResponse response = new EmailDefinitionResponse();
        response.setId(entity.getId());
        response.setEmailGroupId(entity.getEmailGroupId());
        response.setEmailName(entity.getEmailName());
        response.setHtmlEmail(entity.getHtmlEmail());;
        response.setSubjectLine(entity.getSubjectLine());
        response.setEmailContent(entity.getEmailContent());
        response.setFromAddress(entity.getFromAddress());
        response.setFromName(entity.getFromName());
        response.setCCAddress(entity.getCCAddress());
        response.setBCCAddress(entity.getBCCAddress());
        response.setCreatedDate(entity.getCreatedDate());
        response.setReplyToName(entity.getReplyToName());
        response.setReplyToAddress(entity.getReplyToAddress());
        response.setObsolete(entity.getObsolete());
        response.setUpdatedDate(entity.getUpdatedDate());
        return response;
       
    }

    public static List<EmailDefinitionResponse> listOfEmailDefinitionEntityToEmailDefinitionResponse(List<EmailDefinitionEntity> entities){
        List<EmailDefinitionResponse> listOfResponses = new LinkedList<>();

        entities.forEach(entity->{
            listOfResponses.add(entityToResponse(entity));
        });
        return listOfResponses;
    }
    public static List<EmailDefinitionEntity> listOfRequestToEntity(List<EmailDefinitionRequest> requests){
        List<EmailDefinitionEntity> listOfEntity=new LinkedList<>();

        requests.forEach(request->{
            listOfEntity.add(requestToEntity(request));
        });
        return listOfEntity;
    }
}
