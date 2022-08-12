package com.coedify.sep.backend.CourseService.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.coedify.sep.backend.CourseService.commons.converter.PostConverter;
import com.coedify.sep.backend.CourseService.exception.AssetNotFoundException;
import com.coedify.sep.backend.CourseService.models.dto.request.PostRequest;
import com.coedify.sep.backend.CourseService.models.dto.response.PostResponse;
import com.coedify.sep.backend.CourseService.models.dto.response.ReplyResponse;
import com.coedify.sep.backend.CourseService.models.entity.PostEntity;
import com.coedify.sep.backend.CourseService.models.repository.PostRepository;
import com.coedify.sep.backend.CourseService.models.repository.ReplyRepository;
import com.coedify.sep.backend.CourseService.services.PostService;
import com.coedify.sep.backend.CourseService.services.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private ReplyRepository replyRepository;
  @Autowired
  private ReplyService replyService;

  // Create A Post
  @Transactional
  @Override
  public PostResponse savePost(PostRequest request) {
    log.info("Saved post");
    return PostConverter.entityToResponse(postRepository.save(PostConverter.requestToEntity(request)));
  }

  // Get Post By Id
  @Override
  public PostResponse getPostById(Long id) {
    // return PostConverter.entityToResponse
    if (!postRepository.existsById(id)) {
      throw new AssetNotFoundException("post id does not Exist -" + id); // throw exception

    }

    PostResponse response = PostConverter.entityToResponse(postRepository.findById(id).get());
    List<ReplyResponse> replyResponse = replyService.getAllRepliesWithLikeComment(id);
    response.setReplies(replyResponse);
    return response;
  }

  // Get all Posts
  public List<PostResponse> getAllPost() {
    List<PostEntity> entity = postRepository.findAll();
    log.info("fetching all post");
    return PostConverter.listOfEntityToResponse(entity);
  }

  // Update a Post- Returning Updated Response
  public PostResponse updatePostResponse(Long id, PostRequest request) {
    PostEntity entity = postRepository.getById(id);
    entity.setPostTitle(request.getPostTitle());
    entity.setPostBody(request.getPostBody());
    log.info("post text updated");
    return PostConverter.entityToResponse(postRepository.save(entity));
  }

  // Get All Posts With Replies
  @Override
  public List<PostResponse> getAllPostWithReplies() {
    List<PostResponse> listOfPost = getAllPost();
    List<PostResponse> listOfPostWithReplies = new ArrayList<>();
    listOfPost.forEach(post -> {
      List<ReplyResponse> replies = replyService.getAllRepliesWithLikeComment(post.getId());
      post.setReplies(replies);
      listOfPostWithReplies.add(post);
    });
    log.info("returning replies on postId");
    return listOfPostWithReplies;
  }

  // Delete Post With its Replies,Comment & Likes.
  @Transactional
  @Override
  public void deletePostWithRepliesCommentsAndLikes(Long postId) {
    if (replyRepository.existsReplyByPostId(postId)) {
      log.error("post id doesn't exist in reply table", postId);
      replyRepository.findAllByPostId(postId).forEach(entity -> {
        replyService.deleteReplyWithLikesAndComments(entity.getId());
      });
    }
    postRepository.deleteById(postId);
    log.info("post id deleted");
  }

  // Returning List of all posts with replies, and likes.
  @Transactional
  @Override
  public List<PostResponse> getAllPostByModuleId(Long moduleId) {
    List<PostResponse> listOfAllPostResponse = new ArrayList<>();

    System.out.println("Posts: " + postRepository.findAllByModuleId(moduleId));

    PostConverter.listOfEntityToResponse(postRepository
        .findAllByModuleId(moduleId)).forEach(post -> {
          List<ReplyResponse> replies = replyService.getAllRepliesByPostId(post.getId());
          // System.out.println(replies);
          post.setReplies(replies);
          listOfAllPostResponse.add(post);
        });

    return listOfAllPostResponse;
  }

    // // Returning List of all post with their replies, and likes
    // @Transactional
    // @Override
    //  public List<PostResponse> getAllPostByModuleId(Long moduleId) {
    //    List<PostResponse> listOfAllPostResponse = new ArrayList<>();

    //    System.out.println("Posts: "+postRepository.findAllByModuleId(moduleId));
       
    //    PostConverter.listOfEntityToResponse(postRepository
    //    .findAllByModuleId(moduleId)) .forEach(post->{
    //      List<ReplyResponse> replies = replyService.getAllRepliesByPostId(post.getId());
    //      // System.out.println(replies);
    //      post.setReplies(replies);
    //      listOfAllPostResponse.add(post);
    //    });
 
    //    return listOfAllPostResponse;
    //  }
 

}
