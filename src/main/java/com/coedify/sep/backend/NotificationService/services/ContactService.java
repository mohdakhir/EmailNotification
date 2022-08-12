package com.coedify.sep.backend.NotificationService.services;

import com.coedify.sep.backend.NotificationService.models.dto.request.ContactRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactResponse;

public interface ContactService {
    public ContactResponse saveContact(ContactRequest request);
    
}
