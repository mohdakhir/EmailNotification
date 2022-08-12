package com.coedify.sep.backend.NotificationService.services.impl;

import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.NotificationService.commons.converter.ContactTypeConverter;
import com.coedify.sep.backend.NotificationService.models.dto.request.ContactTypeRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactTypeResponse;
import com.coedify.sep.backend.NotificationService.models.entity.ContactTypeEntity;
import com.coedify.sep.backend.NotificationService.models.repository.ContactTypeRepository;
import com.coedify.sep.backend.NotificationService.services.ContactTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactTypeServiceImpl implements ContactTypeService{
    @Autowired
    private ContactTypeRepository contactTypeRepo;
    @Override
    public ContactTypeResponse createContactType(ContactTypeRequest request) {
          return  ContactTypeConverter.entityToResponse(contactTypeRepo.save(ContactTypeConverter.requestToEntity(request)));
    }
    @Override
    public ContactTypeResponse findContactType(Long id) {
        if(!contactTypeRepo.existsById(id))
        {
            throw new AssetNotFoundException(id+" does not exist");
        }
       return ContactTypeConverter.entityToResponse(contactTypeRepo.findById(id).get());
    }
    @Override
    public String deleteContactType(Long id) {
        if(!contactTypeRepo.existsById(id))
        {
            throw new AssetNotFoundException(id+" does not exist");
        }
        contactTypeRepo.deleteById(id);
        return "successfully deleted id"+id;
    }
    @Override
    public ContactTypeResponse updateContactType(Long id,ContactTypeRequest request) {
       ContactTypeEntity entity=contactTypeRepo.findById(id).get();
       entity.setId(request.getId());
       entity.setContactType(request.getContactType());
       return ContactTypeConverter.entityToResponse(contactTypeRepo.save(entity));
    }
}
