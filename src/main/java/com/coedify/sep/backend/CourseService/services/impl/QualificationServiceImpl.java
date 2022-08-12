package com.coedify.sep.backend.CourseService.services.impl;


import java.util.List;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.commons.converter.QualificationConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.QualificationRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.QualificationResponse;
import com.coedify.sep.backend.CourseService.models.pojo.QualificationDetails;
import com.coedify.sep.backend.CourseService.models.repository.QualificationRespository;
import com.coedify.sep.backend.CourseService.services.QualificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class QualificationServiceImpl implements QualificationService{
  
  @Autowired
  private QualificationRespository qualificationRespository;

  @Override
  public QualificationResponse postQualification(QualificationRequest request) {
    
    log.info("creating a qualification for staff");
    return QualificationConverter.entityToResponse(qualificationRespository.save(QualificationConverter.requestToEntity(request)));
  }

  @Override
  public List<QualificationDetails> fetchAll() {

    log.info("get all qualifications of every staff");
    return qualificationRespository.getQualificationDetails();
  }


  @Override
  public List<QualificationResponse> fetchByStaffId(Long staffId) {

    log.info("get all qualifications of a particular Staff");
    return QualificationConverter.listOfEntityToResponse(qualificationRespository.getAllByStaffId(staffId));
  }


  @Override
  public List<QualificationResponse> updateQualification(List<QualificationRequest> request) {

    log.info("updating all qualifications of a particular staff");
    return QualificationConverter.listOfEntityToResponse(
        qualificationRespository.saveAll(QualificationConverter.listOfRequestToEntity(request)));

  }


  @Transactional
  @Override
  public void deleteQualification(Long staffId) {
    
    log.info("deleting all qualifications of a particular staff");
    qualificationRespository.deleteByStaffId(staffId);
  }
  
  
}
