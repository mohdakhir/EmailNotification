package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffResponse;
import com.coedify.sep.backend.CourseService.models.pojo.StaffAndStaffType;

public interface StaffService {
    public StaffResponse createAStaff(StaffRequest request);

    public List<StaffAndStaffType> getAllStaff();

    public StaffResponse getStaffById(Long requestId);

    public StaffResponse updateStaff(StaffRequest request, Long requestId);

    public void deleteStaffByID(Long requestId);

}
