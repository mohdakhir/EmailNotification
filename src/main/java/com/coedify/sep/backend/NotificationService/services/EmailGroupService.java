package com.coedify.sep.backend.NotificationService.services;



import com.coedify.sep.backend.NotificationService.models.dto.request.EmailGroupRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailGroupResponse;

public interface EmailGroupService {

    EmailGroupResponse createEmailGroup(EmailGroupRequest request);

    EmailGroupResponse findEmailGroup(Long id);
    
}
