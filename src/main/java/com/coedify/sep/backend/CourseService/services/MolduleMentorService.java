package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ModuleMentorRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ModuleMentorResponse;
import com.coedify.sep.backend.CourseService.models.entity.ModuleMentorEntity;

public interface MolduleMentorService {

   public List<?> insertEntity(ModuleMentorRequest request);

   public void deleteModule(Long moduleId);

public List<?> updateEntity(ModuleMentorRequest request, Long id);
    
}
