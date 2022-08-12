package com.coedify.sep.backend.CourseService.services.impl;

import java.util.List;
import java.util.Optional;

import com.coedify.sep.backend.CourseService.commons.converter.StaffConverter;
import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.CourseService.models.dto.request.StaffRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffResponse;
import com.coedify.sep.backend.CourseService.models.entity.StaffEntity;
import com.coedify.sep.backend.CourseService.models.pojo.StaffAndStaffType;
import com.coedify.sep.backend.CourseService.models.repository.StaffRepository;
import com.coedify.sep.backend.CourseService.models.repository.StaffTypeRepository;
import com.coedify.sep.backend.CourseService.services.StaffService;
import com.coedify.sep.backend.CourseService.services.StaffTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffTypeRepository staffTypeRepository;

    @Autowired
    StaffTypeService staffTypeService;

    @Override
    public StaffResponse createAStaff(StaffRequest request) {

        StaffResponse response = StaffConverter
                .entityToResponse(staffRepository.save(StaffConverter.requestToEntity(request)));

        return response;

    }

    @Override
    public List<StaffAndStaffType> getAllStaff() {

        return staffRepository.getStaffWithStaffType();

    }

    @Override
    public StaffResponse getStaffById(Long id) {
        if (!staffRepository.existsById(id)) {
            throw new AssetNotFoundException("Staff id not present :" + id);
        }

        return StaffConverter.entityToResponse(staffRepository.findById(id).get());

    }

    @Override
    public StaffResponse updateStaff(StaffRequest request, Long id) {
        if (!staffRepository.existsById(id)) {
            throw new AssetNotFoundException("Staff id not present :" + id);
        }

        Optional<StaffEntity> entity = staffRepository.findById(id);

        entity.get().setName(request.getName());
        entity.get().setEmail(request.getEmail());
        entity.get().setMobileNumber(request.getMobileNumber());
        entity.get().setStaffTypeId(request.getStaffTypeId());
        return StaffConverter.entityToResponse(staffRepository.save(entity.get()));

    }

    @Override
    public void deleteStaffByID(Long id) {

        if (!staffRepository.existsById(id)) {
            throw new AssetNotFoundException("Staff Id Does Not Exists :" + id);
        }

        staffRepository.deleteById(id);
    }

}
