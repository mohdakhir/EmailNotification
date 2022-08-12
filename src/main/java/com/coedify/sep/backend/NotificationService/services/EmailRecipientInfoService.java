package com.coedify.sep.backend.NotificationService.services;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailRecipientInfoRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailRecipientInfoResponse;

public interface EmailRecipientInfoService {
    EmailRecipientInfoResponse createRecipientInfo(EmailRecipientInfoRequest request);

    EmailRecipientInfoResponse getRecipientInfo(Long id);

    EmailRecipientInfoResponse addToContactList(Long id,EmailRecipientInfoRequest request);

    public String deleteRecipientInfo(EmailRecipientInfoRequest request);

    EmailRecipientInfoResponse updateEmailDeployemntById(Long id,EmailRecipientInfoRequest request);
   
}
