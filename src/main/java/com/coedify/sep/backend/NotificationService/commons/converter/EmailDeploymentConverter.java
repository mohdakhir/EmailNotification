package com.coedify.sep.backend.NotificationService.commons.converter;
import java.util.LinkedList;
import java.util.List;
import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDeploymentRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDeploymentResponse;
import com.coedify.sep.backend.NotificationService.models.entity.EmailDeploymentEntity;

public class EmailDeploymentConverter {
    public static EmailDeploymentEntity requestToEntity(EmailDeploymentRequest request){
        EmailDeploymentEntity  entity = new  EmailDeploymentEntity ();
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setEmailDefinitionId(request.getEmailDefinitionId());
        entity.setStatus(request.getStatus());
        entity.setHtmlEmail(request.getHtmlEmail());
        entity.setSenderContactId(request.getSenderContactId());
        entity.setObsolete(request.getObsolete());
        entity.setTotalSent(request.getTotalSent());
        entity.setTotalFailed(request.getTotalFailed());
        entity.setCreatedDate(request.getCreatedDate());
        entity.setPriority(request.getPriority());
        entity.setStartDate(request.getStartDate());
        entity.setFinishDate(request.getFinishDate());
        entity.setScheduleDate(request.getScheduleDate());
        entity.setBatch(request.getBatch());
        return entity;
    }
    public static EmailDeploymentResponse entityToResponse(EmailDeploymentEntity entity){
        EmailDeploymentResponse response = new EmailDeploymentResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setEmailDefinitionId(entity.getEmailDefinitionId());
        response.setStatus(entity.getStatus());
        response.setPriority(entity.getPriority());
        response.setHtmlEmail(entity.getHtmlEmail());
        response.setSenderContactId(entity.getSenderContactId());
        response.setObsolete(entity.getObsolete());
        response.setTotalSent(entity.getTotalSent());
        response.setTotalFailed(entity.getTotalFailed());
        response.setCreatedDate(entity.getCreatedDate());
        response.setStartDate(entity.getStartDate());
        response.setFinishDate(entity.getFinishDate());
        response.setScheduleDate(entity.getScheduleDate());
        response.setBatch(entity.getBatch());
        return response;
       
    }
    public static List<EmailDeploymentResponse> listOfEmailDeploymentEntityToEmailDeplymentResponse(List<EmailDeploymentEntity> entities){
        List<EmailDeploymentResponse> listOfResponses = new LinkedList<>();

        entities.forEach(entity->{
            listOfResponses.add(entityToResponse(entity));
        });
        return listOfResponses;
    }
    public static List<EmailDeploymentEntity> listOfRequestToEntity(List<EmailDeploymentRequest> requests){
        List<EmailDeploymentEntity> listOfEntity=new LinkedList<>();

        requests.forEach(request->{
            listOfEntity.add(requestToEntity(request));
        });
        return listOfEntity;
    }

}
