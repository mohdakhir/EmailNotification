package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.MentorRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.MentorResponse;
import com.coedify.sep.backend.CourseService.models.entity.MentorEntity;

public interface MentorService {

    MentorResponse saveMentor(MentorRequest request);

    List<MentorResponse> getMentors();

    MentorResponse getMentor(Long id);

    MentorEntity deleMentorEntity(Long requestId);

    MentorEntity updateEntity(MentorRequest request, Long id);
    
}
