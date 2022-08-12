package com.coedify.sep.backend.CourseService.commons.converter;

import java.util.ArrayList;
import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.UniversityBoardRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.UniversityBoardResponse;
import com.coedify.sep.backend.CourseService.models.entity.UniversityBoardEntity;

public class UniversityBoardConverter {
  
  public static UniversityBoardEntity requestToEntity(UniversityBoardRequest request) {
    
    UniversityBoardEntity entity = new UniversityBoardEntity();

    entity.setUniversityBoard(request.getUniversityBoard());
    entity.setType(request.getType());
    entity.setId(request.getId());

    return entity;
  }

  public static UniversityBoardResponse entityToResponse(UniversityBoardEntity entity) {

    UniversityBoardResponse response = new UniversityBoardResponse();

    response.setUniversityBoard(entity.getUniversityBoard());
    response.setType(entity.getType());
    response.setId(entity.getId());

    return response;
  }

  public static List<UniversityBoardEntity> listOfRequestToEntity(List<UniversityBoardRequest> requestList) {

    List<UniversityBoardEntity> entityList = new ArrayList<>();

    requestList.forEach(value -> {
      entityList.add(UniversityBoardConverter.requestToEntity(value));
    });

    return entityList;

  }
  
  public static List<UniversityBoardResponse> listOfEntityToResponse(List<UniversityBoardEntity> entityList) {
    
    List<UniversityBoardResponse> responseList = new ArrayList<>();

    entityList.forEach(value->{
      responseList.add(UniversityBoardConverter.entityToResponse(value));
    });

    return responseList;
  }


}
