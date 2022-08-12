package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.coedify.sep.backend.CourseService.models.dto.request.MentorRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.MentorResponse;
import com.coedify.sep.backend.CourseService.models.entity.MentorEntity;
import com.coedify.sep.backend.CourseService.services.MentorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/v1")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @PostMapping("/mentors")
    MentorResponse saveMentor(@RequestBody @Valid MentorRequest request){

        return mentorService.saveMentor(request);
    }

    @GetMapping("/mentors")
    List<MentorResponse> getMentors(){
        

        return mentorService.getMentors();
    }

    @GetMapping("/mentors/{mentorId}")
    MentorResponse getMentor(@PathVariable Long mentorId) throws Exception{
        log.info("Getting mentor for id "+mentorId);
        if(mentorId==1)
        {
            throw new Exception("Id is 1");
        }
        log.debug("Checking getMentor by Id", mentorId);
        return mentorService.getMentor(mentorId);
        
    }

    @DeleteMapping("/mentors/{requestId}")
     MentorEntity deleMentorEntity(@PathVariable Long requestId){
         return mentorService.deleMentorEntity(requestId);
     }

     @PutMapping("/mentors/{id}")
      MentorEntity updateEntity(@RequestBody MentorRequest request ,@PathVariable Long id){
          return mentorService.updateEntity(request , id);
      }

    
}
