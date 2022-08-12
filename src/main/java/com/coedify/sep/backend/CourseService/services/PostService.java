package com.coedify.sep.backend.CourseService.services;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.dto.request.PostRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.PostResponse;

public interface PostService {

    public PostResponse savePost(PostRequest request);

    public PostResponse getPostById(Long id);

    public List<PostResponse> getAllPost();

    public List<PostResponse> getAllPostByModuleId(Long moduleId);

    public PostResponse updatePostResponse(Long id, PostRequest request);

    public void deletePostWithRepliesCommentsAndLikes(Long postId);

    public List<PostResponse> getAllPostWithReplies();

}
