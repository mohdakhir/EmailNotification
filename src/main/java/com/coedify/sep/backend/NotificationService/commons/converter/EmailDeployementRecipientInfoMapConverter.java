package com.coedify.sep.backend.NotificationService.commons.converter;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDeployementRecipientInfoMapRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDeployementRecipientInfoMapResponse;                        
import com.coedify.sep.backend.NotificationService.models.entity.EmailDeployementRecipientInfoMapEntity;


public class EmailDeployementRecipientInfoMapConverter 
{
    public static EmailDeployementRecipientInfoMapEntity requestToEntity(EmailDeployementRecipientInfoMapRequest request)
    {
        EmailDeployementRecipientInfoMapEntity  entity =new EmailDeployementRecipientInfoMapEntity();
          entity.setEmailRecipientInfoId(request.getEmailRecipientInfoId());
          entity.setEmailDeploymentId(request.getEmailDeploymentId());
            return entity;
            
    }
        public static EmailDeployementRecipientInfoMapResponse entityToResponse(EmailDeployementRecipientInfoMapEntity mapEntity)
        {
            EmailDeployementRecipientInfoMapResponse  response =new EmailDeployementRecipientInfoMapResponse ();
            response.setEmailRecipientInfoId(mapEntity.getEmailRecipientInfoId());
            response.setEmailDeploymentId(mapEntity.getEmailDeploymentId());
            return response;
        }
}
