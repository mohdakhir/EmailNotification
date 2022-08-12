package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;
import java.util.Optional;

import com.coedify.sep.backend.CourseService.commons.converter.MentorConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.MentorRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.MentorResponse;
import com.coedify.sep.backend.CourseService.models.entity.MentorEntity;
import com.coedify.sep.backend.CourseService.models.repository.MentorRepository;
import com.coedify.sep.backend.CourseService.services.MentorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    MentorRepository mentorRepository;
    
    @Override
    public
    MentorResponse saveMentor(MentorRequest request) {

        return MentorConverter.entityToResponse(mentorRepository.save(MentorConverter.requestToEntity(request)));
    }

    @Override
    public List<MentorResponse> getMentors() {
        List<MentorEntity> entityList = mentorRepository.findAll();
        List<MentorResponse> responseList = MentorConverter.listOfEntityToResponses(entityList);
        return responseList;
    }

    @Override
    public MentorResponse getMentor(Long id) {
        
        return MentorConverter.entityToResponse(mentorRepository.getById(id));
    }
    
    @Override
    public MentorEntity deleMentorEntity(Long requestId){
         Optional<MentorEntity> entity = mentorRepository.findById(requestId);
         mentorRepository.delete(entity.get());
        return null;
    }

    public MentorEntity updateEntity(MentorRequest request, Long id){
          Optional<MentorEntity> entity=mentorRepository.findById(id);
          entity.get().setName(request.getName());
          entity.get().setSkypeId(request.getSkypeId());
          entity.get().setContact(request.getContact());
           return mentorRepository.save(entity.get());
    }

}
