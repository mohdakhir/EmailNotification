package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.converter.UniversityBoardConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.UniversityBoardRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.UniversityBoardResponse;
import com.coedify.sep.backend.CourseService.models.entity.UniversityBoardEntity;
import com.coedify.sep.backend.CourseService.models.repository.UniversityBoardRepository;
import com.coedify.sep.backend.CourseService.services.UniversityBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityBoardServiceImpl implements UniversityBoardService {

  @Autowired
  private UniversityBoardRepository universityBoardRespository;

  @Override
  public UniversityBoardResponse createUniversityBoard(UniversityBoardRequest request) {

    return UniversityBoardConverter
        .entityToResponse(universityBoardRespository.save(UniversityBoardConverter.requestToEntity(request)));
  }

  @Override
  public List<UniversityBoardResponse> fetchAll() {

    return UniversityBoardConverter.listOfEntityToResponse(universityBoardRespository.findAll());
  }

  @Override
  public UniversityBoardResponse fetchById(long id) {

    return UniversityBoardConverter.entityToResponse(universityBoardRespository.findById(id).get());
  }

  @Override
  public UniversityBoardResponse updateUniversityBoard(UniversityBoardRequest request) {

    return UniversityBoardConverter
        .entityToResponse(universityBoardRespository.save(UniversityBoardConverter.requestToEntity(request)));
  }

  @Override
  public void deleteUniversityBoard(long id) {

    universityBoardRespository.deleteById(id);
  }

}
