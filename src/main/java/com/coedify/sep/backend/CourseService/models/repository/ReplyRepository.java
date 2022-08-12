package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.ReplyEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

    @Query(value = "select * from reply r where r.post_id =:id", nativeQuery = true)
    List<ReplyEntity> noOfRepliesForAPost(@Param("id") Long postId);

    Boolean existsReplyByPostId(Long postId);

    void deleteAllByPostId(Long postId);

    @Query(value = "select * from reply r where r.post_id=?1", nativeQuery = true)
    List<ReplyEntity> findAllByPostId(@Param("postId") Long postId);

    List<ReplyEntity> findAllById(Long postId);

}
