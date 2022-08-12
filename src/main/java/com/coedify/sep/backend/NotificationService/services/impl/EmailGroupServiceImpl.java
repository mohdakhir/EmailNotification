package com.coedify.sep.backend.NotificationService.services.impl;

import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.NotificationService.commons.converter.EmailGroupConverter;
import com.coedify.sep.backend.NotificationService.models.dto.request.EmailGroupRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailGroupResponse;
import com.coedify.sep.backend.NotificationService.models.repository.EmailGroupRepository;
import com.coedify.sep.backend.NotificationService.services.EmailGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailGroupServiceImpl implements EmailGroupService {
    @Autowired
    private EmailGroupRepository emailGroupRepo;

    @Override
    public EmailGroupResponse createEmailGroup(EmailGroupRequest request) {
        EmailGroupResponse response=new EmailGroupResponse();
       response= EmailGroupConverter.entityToResponse(emailGroupRepo.save(EmailGroupConverter.requestToEntity(request)));
       return response;
    }

    @Override
    public EmailGroupResponse findEmailGroup(Long id) {
        if(!emailGroupRepo.existsById(id))
        {
            throw new AssetNotFoundException(id+" does not exist");
        }
       return EmailGroupConverter.entityToResponse(emailGroupRepo.findById(id).get());
    }
}
