package com.coedify.sep.backend.services;

import static org.mockito.Mockito.verify;

import com.coedify.sep.backend.CourseService.models.repository.TopicRepository;
import com.coedify.sep.backend.CourseService.services.impl.TopicServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class TopicServiceTest {

    @Mock
    private TopicRepository topicRepository;

   
    private TopicServiceImpl topicService;

    @BeforeEach
    void setUp()
    {
        this.topicService= new TopicServiceImpl(this.topicRepository);
    }
    

    @Test
    void testGetAllTopics() {
        topicService.getAllTopics();
        verify(topicRepository).findAll();

    }

    
}
