package com.coedify.sep.backend.CourseService.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.coedify.sep.backend.CourseService.models.dto.request.TopicRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.TopicResponse;
import com.coedify.sep.backend.CourseService.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/v1")
public class TopicController {

      @Autowired
      TopicService topicService;

      //  API to insert a particular topic

      @PostMapping("/topic")
      TopicResponse insertTopic(@RequestBody @Valid TopicRequest topicRequest) {

            return topicService.insertTopic(topicRequest);

      }

      //  API to update a particular topic

      @PutMapping("/topic/{topicId}")
      TopicResponse updateTopic(@RequestBody @Valid TopicRequest topicRequest, @PathVariable("topicId") long topicId ){
          
           return topicService.updateTopic(topicRequest, topicId);
      }

      
      // API to get a particular topic 

      @GetMapping("/topic/{topicId}")
      TopicResponse getTopic(@PathVariable("topicId") long topicId){
            return topicService.getTopic(topicId);
      }

      // API to get all the topics

      @GetMapping("/topic")
      List<TopicResponse> getAllTopics(){
            return topicService.getAllTopics();
      }

      @DeleteMapping("/topic/{topicId}")
      void deleteByTopicId(@PathVariable("topicId") Long topicId){
            topicService.deleteTopic(topicId);
      }





}
