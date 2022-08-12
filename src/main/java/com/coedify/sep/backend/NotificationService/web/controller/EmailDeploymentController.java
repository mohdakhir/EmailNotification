package com.coedify.sep.backend.NotificationService.web.controller;
import javax.validation.Valid;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDeploymentRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDeploymentResponse;
import com.coedify.sep.backend.NotificationService.services.EmailDeploymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmailDeploymentController extends BaseController {
    @Autowired
    private EmailDeploymentService emailDeploymentService ;
     @PostMapping("/emailDeployment")
     public EmailDeploymentResponse createDeployment(@RequestBody @Valid EmailDeploymentRequest request)
     {
        return  emailDeploymentService.createDeployment(request);
     }
     @GetMapping("/emailDeployment/{id}")
     public EmailDeploymentResponse getDeploymentById(@PathVariable Long id)
     {
        return  emailDeploymentService.getDeploymentById(id);
     }
     @DeleteMapping("/emailDeployment/{id}")
     public String deleteDeploymentById(@PathVariable Long id)
     {
        return  emailDeploymentService.deleteDeploymentById(id);
     }
    
}
