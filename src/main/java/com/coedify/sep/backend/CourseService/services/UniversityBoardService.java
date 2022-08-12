package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.UniversityBoardRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.UniversityBoardResponse;

public interface UniversityBoardService {

  UniversityBoardResponse createUniversityBoard(UniversityBoardRequest request);

  List<UniversityBoardResponse> fetchAll();

  UniversityBoardResponse fetchById(long id);

  void deleteUniversityBoard(long id);

  UniversityBoardResponse updateUniversityBoard(UniversityBoardRequest request);
  
}
