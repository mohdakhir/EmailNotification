package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.TopicRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.TopicResponse;

import org.springframework.stereotype.Service;



@Service
public interface TopicService {
    TopicResponse insertTopic(TopicRequest topicRequest);
    TopicResponse updateTopic(TopicRequest topicRequest, long topicId);
    TopicResponse getTopic(long topicId);
    List<TopicResponse> getAllTopics();
    void deleteTopic(Long topicId);
           

    
  }

