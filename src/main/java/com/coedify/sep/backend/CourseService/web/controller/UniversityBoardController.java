package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.UniversityBoardRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.UniversityBoardResponse;
import com.coedify.sep.backend.CourseService.services.UniversityBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/v1")
public class UniversityBoardController {
  
  @Autowired
  private UniversityBoardService universityBoardService;

  

  @PostMapping("/postUniversityBoard")
  public UniversityBoardResponse create(@RequestBody UniversityBoardRequest request) {

    return universityBoardService.createUniversityBoard(request);

  }

  @PostMapping("/getAllUniversityBoard")
  public List<UniversityBoardResponse> getAll() {
    return universityBoardService.fetchAll();
  }

  @PostMapping("/getUniversityBoardById")
  public UniversityBoardResponse getById(@RequestBody UniversityBoardRequest
  request) {

    return universityBoardService.fetchById(request.getId());
  }

  @PostMapping("/updateUniversityBoard")
  public UniversityBoardResponse update(@RequestBody UniversityBoardRequest request) {

    return universityBoardService.updateUniversityBoard(request);
  }

  @PostMapping("/deleteUniversityBoard")
  public void delete(@RequestBody UniversityBoardRequest request) {
    
     universityBoardService.deleteUniversityBoard(request.getId());
  }

  
  
}
