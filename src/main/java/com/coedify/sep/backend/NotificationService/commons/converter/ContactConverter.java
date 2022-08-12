package com.coedify.sep.backend.NotificationService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.NotificationService.models.dto.request.ContactRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.ContactResponse;
import com.coedify.sep.backend.NotificationService.models.entity.ContactEntity;

public class  ContactConverter{
    public static ContactEntity requestToEntity(ContactRequest request){

        ContactEntity entity = new ContactEntity();
        entity.setId(request.getId());
       entity.setCreatedDate(request.getCreatedDate());
        entity.setUpdatedDate(request.getUpdatedDate());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmailAddress(request.getEmailAddress());
        entity.setTitle(request.getTitle());
        entity.setContactTypeId(request.getContactTypeId());
        entity.setCompanyName(request.getCompanyName());
        entity.setAddress1(request.getAddress1());
        entity.setAddress2(request.getAddress2());
        entity.setCity(request.getCity());
        entity.setState(request.getState());
        entity.setPin(request.getPin());
        entity.setCountry(request.getCountry());
        entity.setMobileNumber(request.getMobileNumber());
        entity.setBusinessPhone(request.getBusinessPhone());
        entity.setCompanyId(request.getCompanyId());
        entity.setObsolete(request.isObsolete());
        return entity;
    }

    public static ContactResponse entityToResponse(ContactEntity entity){

        ContactResponse response=new ContactResponse();
        response.setId(entity.getId());
       response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setLastName(entity.getLastName());
        response.setEmailAddress(entity.getEmailAddress());
        response.setFirstName(entity.getFirstName());
        response.setTitle(entity.getTitle());
        response.setContactTypeId(entity.getContactTypeId());
        response.setCompanyName(entity.getCompanyName());
        response.setAddress1(entity.getAddress1());
        response.setAddress2(entity.getAddress2());
        response.setCity(entity.getCity());
        response.setState(entity.getState());
        response.setPin(entity.getPin());
        response.setCountry(entity.getCountry());
        response.setMobileNumber(entity.getMobileNumber());
        response.setBusinessPhone(entity.getBusinessPhone());
        response.setCompanyId(entity.getCompanyId());
        response.setObsolete(entity.isObsolete());
        return response;
    }

    public static List<ContactResponse> listOfEntityToResponses(List<ContactEntity> entityList){
    List<ContactResponse> listResponse = new LinkedList<ContactResponse>();
    entityList.forEach(entity -> {
        listResponse.add(entityToResponse(entity));
    });

    return listResponse;
}

public static List<ContactEntity> listOfResponseToEntities(List<ContactRequest> requestList){
    List<ContactEntity> listEntity = new LinkedList<ContactEntity>();
    requestList.forEach(request -> {
        listEntity.add(requestToEntity(request));
    });

    return listEntity;
}
}
