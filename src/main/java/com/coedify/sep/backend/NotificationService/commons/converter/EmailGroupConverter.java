package com.coedify.sep.backend.NotificationService.commons.converter;

import com.coedify.sep.backend.NotificationService.models.dto.request.EmailGroupRequest;
import com.coedify.sep.backend.NotificationService.models.dto.response.EmailGroupResponse;
import com.coedify.sep.backend.NotificationService.models.entity.EmailGroupEntity;

public class EmailGroupConverter {
    public static EmailGroupResponse entityToResponse (EmailGroupEntity entity)
    {
        EmailGroupResponse response=new EmailGroupResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setObsolete(entity.getObsolete());
        response.setCreatedDate(entity.getCreatedDate());
        response.setDescription(entity.getDescription());
        response.setUpdatedDate(entity.getUpdatedDate());
        return response;
    }
    public static EmailGroupEntity requestToEntity (EmailGroupRequest request)
    {
        EmailGroupEntity entity=new EmailGroupEntity();
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setObsolete(request.getObsolete());
        entity.setCreatedDate(request.getCreatedDate());
        entity.setDescription(request.getDescription());
        entity.setUpdatedDate(request.getUpdatedDate());
        return entity;
    }
}
