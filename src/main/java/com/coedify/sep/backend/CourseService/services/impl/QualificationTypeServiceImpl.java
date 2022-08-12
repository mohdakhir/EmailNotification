package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.converter.QualificationConverter;
import com.coedify.sep.backend.CourseService.commons.converter.QualificationTypeConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.QualificationTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationTypeResponse;
import com.coedify.sep.backend.CourseService.models.pojo.QualificationType;
import com.coedify.sep.backend.CourseService.models.repository.QualificationTypeRepository;
import com.coedify.sep.backend.CourseService.services.QualificationTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class QualificationTypeServiceImpl implements QualificationTypeService {

  @Autowired
  private QualificationTypeRepository qualificationTypeRepository;


  @Override
  public QualificationTypeResponse createQualificationType(QualificationTypeRequest request) {

    return QualificationTypeConverter
        .entityToResponse(qualificationTypeRepository.save(QualificationTypeConverter.requestToEntity(request)));
  }
  

  @Override
  public List<QualificationTypeResponse> fetchAllQualificationType() {

    return QualificationTypeConverter.entityListToResponseList(qualificationTypeRepository.findAll());
  }


  @Override
  public QualificationTypeResponse fetchById(long id) {

    return QualificationTypeConverter.entityToResponse(qualificationTypeRepository.findById(id).get());
  }


  @Override
  public void deleteById(long id) {
    
    qualificationTypeRepository.deleteById(id);
  }
  
  
  
}
