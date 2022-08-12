package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.StaffTypeRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffTypeResponse;
import com.coedify.sep.backend.CourseService.services.StaffTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class StaffTypeController {

    @Autowired
    StaffTypeService staffTypeService;

    @PostMapping("/createStaffType")
    public StaffTypeResponse createStaffType(@RequestBody StaffTypeRequest request) {

        return staffTypeService.createStaffType(request);
    }

    @PostMapping("/getAllStaffType")
    public List<StaffTypeResponse> getAll() {
        return staffTypeService.getAllStaffType();

    }

    @PostMapping("/getStaffTypeById")
    public StaffTypeResponse getStaffTypeById(@RequestBody StaffTypeRequest request) {
        return staffTypeService.getStaffTypeById(request.getId());

    }

    @PostMapping("/updateStaffType")
    public StaffTypeResponse UpdateStaffType(@RequestBody StaffTypeRequest request) {
        return staffTypeService.updateStaffType(request, request.getId());
    }

}
