package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffEnrollmentRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffEnrollmentResponse;
import com.coedify.sep.backend.CourseService.models.entity.StaffEnrollmentEntity;

public class StaffEnrollmentConverter {

    public static StaffEnrollmentEntity requestToEntity(StaffEnrollmentRequest request){
        
        StaffEnrollmentEntity developerEnrollmentEntity = new StaffEnrollmentEntity();
        developerEnrollmentEntity.setId(request.getId());
        developerEnrollmentEntity.setCourseId(request.getCourseId());
        developerEnrollmentEntity.setStaffId(request.getStaffId());
        developerEnrollmentEntity.setStartDate(request.getStartDate());
        developerEnrollmentEntity.setTentativeEndDate(request.getTentativeEndDate());
        developerEnrollmentEntity.setExtendedDate(request.getExtendedDate());
        developerEnrollmentEntity.setCompletionDate(request.getCompletionDate());
        developerEnrollmentEntity.setCreatedBy(request.getCreatedBy());
        developerEnrollmentEntity.setUpdatedBy(request.getUpdatedBy());
        developerEnrollmentEntity.setCreatedDate(request.getCreatedDate());
        developerEnrollmentEntity.setUpdatedDate(request.getUpdatedDate());
      
        return developerEnrollmentEntity;

    }

    public static StaffEnrollmentResponse entityToResponse(StaffEnrollmentEntity entity){

        StaffEnrollmentResponse dEResponse = new StaffEnrollmentResponse();
        dEResponse.setId(entity.getId());
        dEResponse.setCourseId(entity.getCourseId());
        dEResponse.setStaffId(entity.getStaffId());
        dEResponse.setStartDate(entity.getStartDate());
        dEResponse.setTentativeEndDate(entity.getTentativeEndDate());
        dEResponse.setExtendedDate(entity.getExtendedDate());
        dEResponse.setCompletionDate(entity.getCompletionDate());
        dEResponse.setCreatedBy(entity.getCreatedBy());
        dEResponse.setUpdatedBy(entity.getUpdatedBy());
        dEResponse.setCreatedDate(entity.getCreatedDate());
        dEResponse.setUpdatedDate(entity.getUpdatedDate());


        return dEResponse;

    }

    public static List<StaffEnrollmentResponse> entityListToResopnseList(List<StaffEnrollmentEntity> enrollEntity){

        List<StaffEnrollmentResponse> responseList = new ArrayList<StaffEnrollmentResponse>();

        enrollEntity.forEach(entity ->{
            responseList.add(entityToResponse(entity));
        });

        return responseList;
    }
    
}
