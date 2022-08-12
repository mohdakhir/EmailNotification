package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffTypeResponse;

public interface StaffTypeService {

    public StaffTypeResponse getStaffTypeById(Long id);

    public StaffTypeResponse createStaffType(StaffTypeRequest request);

    public List<StaffTypeResponse> getAllStaffType();

    public StaffTypeResponse updateStaffType(StaffTypeRequest request, Long id);

}
