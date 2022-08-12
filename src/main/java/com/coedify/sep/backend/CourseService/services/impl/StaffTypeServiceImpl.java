package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;
import java.util.Optional;

import com.coedify.sep.backend.CourseService.commons.converter.StaffTypeConverter;
import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.CourseService.models.dto.request.StaffTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffTypeResponse;
import com.coedify.sep.backend.CourseService.models.entity.StaffTypeEntity;
import com.coedify.sep.backend.CourseService.models.repository.StaffRepository;
import com.coedify.sep.backend.CourseService.models.repository.StaffTypeRepository;
import com.coedify.sep.backend.CourseService.services.StaffTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffTypeServiceImpl implements StaffTypeService {

    @Autowired
    StaffTypeRepository staffTypeRepository;

    @Autowired
    StaffRepository staffRepository;

    @Override
    public StaffTypeResponse createStaffType(StaffTypeRequest request) {
        return StaffTypeConverter
                .entityToResponse(staffTypeRepository.save(StaffTypeConverter.requestToEntity(request)));

    }

    @Override
    public List<StaffTypeResponse> getAllStaffType() {
        return StaffTypeConverter.entityListToResponseList(staffTypeRepository.findAll());

    }

    @Override
    public StaffTypeResponse getStaffTypeById(Long id) {

        if (!staffRepository.existsById(id)) {
            throw new AssetNotFoundException("StaffType Id Does Not Exists :" + id);
        }

        return StaffTypeConverter.entityToResponse(staffTypeRepository.findById(id).get());

    }

    @Override
    public StaffTypeResponse updateStaffType(StaffTypeRequest request, Long id)

    {

        if (!staffTypeRepository.existsById(id)) {
            throw new AssetNotFoundException("Staff Type Id Does Not Exists :" + id);
        }

        Optional<StaffTypeEntity> entity = staffTypeRepository.findById(id);
        entity.get().setId(request.getId());
        entity.get().setStaffType(request.getStaffType());
        return StaffTypeConverter.entityToResponse(staffTypeRepository.save(entity.get()));
    }

}
