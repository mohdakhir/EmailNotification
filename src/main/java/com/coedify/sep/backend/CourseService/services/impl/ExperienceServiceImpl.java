package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;

import com.coedify.sep.backend.CourseService.commons.converter.ExperienceConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.ExperienceRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.ExperienceResponse;
import com.coedify.sep.backend.CourseService.models.repository.ExperienceRepository;
import com.coedify.sep.backend.CourseService.services.ExperienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public ExperienceResponse createExperience(ExperienceRequest request) {
        return ExperienceConverter
                .entityToResponse(experienceRepository.save(ExperienceConverter.requestToEntity(request)));
    }

    @Override
    public List<ExperienceResponse> getExperienceById(Long id) {
        return ExperienceConverter.entityListToResponseList(experienceRepository.findByStaffid(id));
    }

    @Override
    public List<ExperienceResponse> getAllxperience() {

        return ExperienceConverter.entityListToResponseList(experienceRepository.findAll());
    }

    @Override
    public List<ExperienceResponse> updateExperience(List<ExperienceRequest> requestList) {
        return ExperienceConverter.entityListToResponseList(
                experienceRepository.saveAll(ExperienceConverter.requestListToEntityList(requestList)));

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        experienceRepository.deleteAllByStaffid(id);
    }

}
