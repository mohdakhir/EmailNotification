package com.coedify.sep.backend.CourseService.commons.converter;

import com.coedify.sep.backend.CourseService.models.dto.request.ModuleMentorRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ModuleMentorResponse;
import com.coedify.sep.backend.CourseService.models.entity.ModuleMentorEntity;

public class ModuleMentorConverter {
    public static ModuleMentorEntity requestToEntity(ModuleMentorRequest request){
        ModuleMentorEntity moduleMentorEntity =new ModuleMentorEntity();

        moduleMentorEntity.setId(request.getId());
        moduleMentorEntity.setCreatedBy(request.getCreatedBy());
        moduleMentorEntity.setCreatedDate(request.getCreatedDate());
        moduleMentorEntity.setUpdatedBy(request.getUpdatedBy());
        moduleMentorEntity.setUpdatedDate(request.getUpdatedDate());
        moduleMentorEntity.setMentorId(request.getMentorId());
        moduleMentorEntity.setModuleId(request.getMentorId());
       
       return moduleMentorEntity;
   }

   public static ModuleMentorResponse entityToResponse(ModuleMentorEntity entity){
    ModuleMentorResponse response=new ModuleMentorResponse();
    response.setId(entity.getId());
    response.setCreatedBy(entity.getCreatedBy());
    response.setCreatedDate(entity.getCreatedDate());
    response.setUpdatedBy(entity.getUpdatedBy());
    response.setUpdatedDate(entity.getUpdatedDate());
    response.setMentorId(entity.getModuleId());
    response.setMentorId(entity.getMentorId());
    
    return response;

}
}
