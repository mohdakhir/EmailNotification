package com.coedify.sep.backend.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.coedify.sep.backend.CourseService.commons.converter.PostConverter;
import com.coedify.sep.backend.CourseService.models.dto.request.PostRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.PostResponse;
import com.coedify.sep.backend.CourseService.models.entity.PostEntity;
import com.coedify.sep.backend.CourseService.models.repository.PostRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*@ExtendWith(
    SpringExtension.class
)
public class PostServiceImplTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postServiceImpl; 

    @Test

    void givenValidPostRequest_savePost_returnResponse()
    {
        PostRequest request =new PostRequest();
        request.setPostTitle("First Question");
        request.setPostBody(("Whats is Java"));
        request.setUserId("Jsb@Gmail.com");
        request.setModuleId(1l);

        //creating an object of PostEntity
        //setting values same as in request
        PostEntity responseFromDataBase=new PostEntity();
        responseFromDataBase.setPostTitle("First Question");
        responseFromDataBase.setPostBody("Whats is Java");
        responseFromDataBase.setUserId("Jsb@Gmail.com");
        responseFromDataBase.setModuleId(1l);

        //we need to Mock PostRepository   //mocked 

        //Tell to TestCase that -When this below call in function is made Then Return "responseFromDataBase" not response(DataBase);
        when (postRepository.save(PostConverter.requestToEntity(request))).thenReturn (responseFromDataBase);

        PostResponse actual =postServiceImpl.savePost(request);  

        assertEquals("First Question",actual.getPostTitle());
        assertEquals("Whats is Java", actual.getPostBody());
        assertEquals("Jsb@Gmail.com", actual.getUserId());
        assertEquals(1l, actual.getModuleId());

        
    }

    
}*/
