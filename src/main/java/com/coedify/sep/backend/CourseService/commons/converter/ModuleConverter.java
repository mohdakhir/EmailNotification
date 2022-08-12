package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.LinkedList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ModuleRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ModuleResponse;
import com.coedify.sep.backend.CourseService.models.entity.ModuleEntity;

public class ModuleConverter {
    public static ModuleEntity requestToEntity(ModuleRequest request){
         ModuleEntity moduleEntity =new ModuleEntity();

         moduleEntity.setId(request.getId());
         moduleEntity.setCreatedBy(request.getCreatedBy());
         moduleEntity.setCreatedDate(request.getCreatedDate());
         moduleEntity.setUpdatedBy(request.getUpdatedBy());
         moduleEntity.setUpdatedDate(request.getUpdatedDate());
         moduleEntity.setName(request.getName());
         moduleEntity.setDescription(request.getDescription());
        return moduleEntity;
    }

    public static ModuleResponse entityToResponse(ModuleEntity entity){
        ModuleResponse response=new ModuleResponse();
        response.setId(entity.getId());
        response.setCreatedBy(entity.getCreatedBy());
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedBy(entity.getUpdatedBy());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        return response;

    }
  
    public static List<ModuleResponse> listOfEntityToResponses(List<ModuleEntity> entityList){
        List<ModuleResponse> listResponse = new LinkedList<ModuleResponse>();
        entityList.forEach(entity -> {
            listResponse.add(entityToResponse(entity));
        });

        return listResponse;
    }
    
    public static List<ModuleEntity> listOfResponseToEntities(List<ModuleRequest> requestList){
        List<ModuleEntity> listEntity = new LinkedList<ModuleEntity>();
        requestList.forEach(request -> {
            listEntity.add(requestToEntity(request));
        });

        return listEntity;
    }

}
