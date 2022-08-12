package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.ModuleMentorRequest;
import com.coedify.sep.backend.CourseService.services.MolduleMentorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ModuleMentorController {
    
    @Autowired
    MolduleMentorService moduleMentorService;

    @PostMapping("/moduleMentor")
    public List<?> insertEntity(@RequestBody ModuleMentorRequest request){
        return moduleMentorService.insertEntity(request);
    }
    
    // detele Module by module id
    @GetMapping("/moduleMentor/{moduleId}")
   void deleteModule(@PathVariable Long moduleId){
        moduleMentorService.deleteModule(moduleId);
    }

    // update
    @PutMapping("/moduleMentors/{id}")
    public List<?> updateEntity(@RequestBody ModuleMentorRequest request ,@PathVariable Long id ){
        return moduleMentorService.updateEntity(request , id);
    }
}
