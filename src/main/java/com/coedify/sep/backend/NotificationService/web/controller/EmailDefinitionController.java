package com.coedify.sep.backend.NotificationService.web.controller;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDefinitionRequest;
import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDeploymentRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDefinitionResponse;
import com.coedify.sep.backend.NotificationService.models.repository.EmailDeploymentRepository;
import com.coedify.sep.backend.NotificationService.services.EmailDefinitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailDefinitionController extends BaseController{
    @Autowired
    private EmailDefinitionService emailDefinitionService;
    @PostMapping("/emailDefinition")
    public EmailDefinitionResponse createEmailDefinition(@RequestBody EmailDefinitionRequest request)
    {
       return emailDefinitionService.createEmailDefinition(request);
    }
    @GetMapping("/emailDefinition/{id}")
    public EmailDefinitionResponse findContactType(@PathVariable Long id)
    {
        return emailDefinitionService.findEmailDefinition(id);
    }
    @DeleteMapping("/emailDefinition/{id}")
    public String deleteEmailDefinition(@PathVariable Long id)
    {
        return emailDefinitionService.deleteEmailDefinition(id);
    }
}
