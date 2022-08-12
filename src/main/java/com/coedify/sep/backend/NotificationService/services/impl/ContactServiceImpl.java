package com.coedify.sep.backend.NotificationService.services.impl;
import com.coedify.sep.backend.NotificationService.commons.converter.ContactConverter;
import com.coedify.sep.backend.NotificationService.models.dto.request.ContactRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactResponse;
import com.coedify.sep.backend.NotificationService.models.repository.ContactRepository;
import com.coedify.sep.backend.NotificationService.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactrepository;
    @Override
    public ContactResponse saveContact(ContactRequest request) {
      return ContactConverter.entityToResponse(contactrepository.save(ContactConverter.requestToEntity(request)));
    }
}
//insert update delete addToList