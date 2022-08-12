package com.coedify.sep.backend.NotificationService.services;


import com.coedify.sep.backend.NotificationService.models.dto.request.ContactTypeRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactTypeResponse;

public interface ContactTypeService {

    ContactTypeResponse createContactType(ContactTypeRequest request);

    ContactTypeResponse findContactType(Long id);

    String deleteContactType(Long id);

    ContactTypeResponse updateContactType(Long id,  ContactTypeRequest request);
   
}
