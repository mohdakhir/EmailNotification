package com.coedify.sep.backend.NotificationService.services;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDefinitionRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDefinitionResponse;

public interface EmailDefinitionService {
    public EmailDefinitionResponse createEmailDefinition(EmailDefinitionRequest request);

    public EmailDefinitionResponse findEmailDefinition(Long id);

    public String deleteEmailDefinition(Long id);
}
