package com.coedify.sep.backend.NotificationService.commons.converter;

import com.coedify.sep.backend.NotificationService.models.dto.request.ContactTypeRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactTypeResponse;
import com.coedify.sep.backend.NotificationService.models.entity.ContactTypeEntity;

public class ContactTypeConverter {
    public static  ContactTypeResponse entityToResponse(ContactTypeEntity entity)
    {
        ContactTypeResponse response =new ContactTypeResponse();
        response.setId(entity.getId());
        response.setContactType(entity.getContactType());
        return response;
    }
    public static ContactTypeEntity requestToEntity(ContactTypeRequest request)
    {
        ContactTypeEntity entity=new  ContactTypeEntity();
        entity.setId(request.getId());
        entity.setContactType(request.getContactType());
        return entity;
    }
}
