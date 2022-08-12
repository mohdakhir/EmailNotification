package com.coedify.sep.backend.services.impl;

import com.coedify.sep.backend.CourseService.models.repository.TopicRepository;
import com.coedify.sep.backend.CourseService.services.impl.TopicServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TopicServiceImplTest {

    @Mock
    private TopicRepository topicRepository;
    @InjectMocks
    private TopicServiceImpl topicServiceImpl;
    @Test
    void testInsertTopic() {


        

    }
}
