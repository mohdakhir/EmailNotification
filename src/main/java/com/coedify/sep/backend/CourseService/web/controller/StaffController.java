package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;
import java.util.Objects;

import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.CourseService.models.dto.request.StaffRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.StaffResponse;
import com.coedify.sep.backend.CourseService.models.pojo.StaffAndStaffType;
import com.coedify.sep.backend.CourseService.models.repository.StaffRepository;
import com.coedify.sep.backend.CourseService.services.CourseService;
import com.coedify.sep.backend.CourseService.services.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StaffService staffService;

    @Autowired
    CourseService courseService;

    @PostMapping("/staff")

    StaffResponse createStaff(@RequestBody StaffRequest request) {

        return staffService.createAStaff(request);
    }

    @PostMapping("/allStaff")
    List<StaffAndStaffType> getAllStaff() {

        return staffService.getAllStaff();
    }

    @PostMapping("/staffById")
    StaffResponse getStaffById(@RequestBody StaffRequest request) {

        return staffService.getStaffById(request.getId());
    }

    @PostMapping("/staffupdate")
    StaffResponse updateDeveloperById(@RequestBody StaffRequest request) {

        return staffService.updateStaff(request, request.getId());
    }

    @PostMapping("/deleteStaff")
    public void deleteStaffById(@RequestBody StaffRequest request) {
   
        staffService.deleteStaffByID(request.getId());
    }
}
