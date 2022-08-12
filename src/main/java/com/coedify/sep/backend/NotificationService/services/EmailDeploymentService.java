package com.coedify.sep.backend.NotificationService.services;


import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDeploymentRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDeploymentResponse;

public interface EmailDeploymentService {
    public EmailDeploymentResponse createDeployment(EmailDeploymentRequest request);

    public EmailDeploymentResponse getDeploymentById(Long id);
    
    public String deleteDeploymentById(Long id);
}
