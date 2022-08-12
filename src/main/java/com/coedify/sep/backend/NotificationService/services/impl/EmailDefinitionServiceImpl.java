package com.coedify.sep.backend.NotificationService.services.impl;
import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.NotificationService.commons.converter.EmailDefinitionConverter;
import com.coedify.sep.backend.NotificationService.models.dto.request.EmailDefinitionRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailDefinitionResponse;
import com.coedify.sep.backend.NotificationService.models.repository.EmailDefinitionRepository;
import com.coedify.sep.backend.NotificationService.models.repository.EmailDeploymentRepository;
import com.coedify.sep.backend.NotificationService.models.repository.EmailGroupRepository;
import com.coedify.sep.backend.NotificationService.services.EmailDefinitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailDefinitionServiceImpl implements EmailDefinitionService{
    @Autowired
    private EmailDefinitionRepository emailDefinitionRepo;
    @Autowired
    private EmailGroupRepository emailGroupRepo;
    @Autowired
    private EmailDeploymentRepository deploymentRepo;
    @Override
    public EmailDefinitionResponse createEmailDefinition(EmailDefinitionRequest request) {
         return EmailDefinitionConverter.entityToResponse(emailDefinitionRepo.save(EmailDefinitionConverter.requestToEntity(request)));
    }
    @Override
    public EmailDefinitionResponse findEmailDefinition(Long id) {
       if(!emailDefinitionRepo.existsById(id))
       {
           throw new AssetNotFoundException("id does not exist");
       }
       return EmailDefinitionConverter.entityToResponse(emailDefinitionRepo.findById(id).orElse(null));
    }
    @Override
    public String deleteEmailDefinition(Long id) {
       if(deploymentRepo.existsByEmailDefinitionId(id))
       {
           throw new AssetNotFoundException("Can not be delete because it present in deployment");
       }
       emailDefinitionRepo.deleteById(id);
       return "succesfully deleted "+id;
    }
}
