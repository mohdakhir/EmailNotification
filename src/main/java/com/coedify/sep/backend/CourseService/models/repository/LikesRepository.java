package com.coedify.sep.backend.CourseService.models.repository;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.entity.LikesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<LikesEntity,Long>{

    //@Query("SELECT l FROM Likes l WHERE l.likesFor = :id")
    @Query(value="select * from likes l where l.reply_id=?1",nativeQuery = true)
    List<LikesEntity> noOfLikesForAReply(@Param("replyId") Long replyId);

    @Modifying
    @Query(value="delete from likes l where l.reply_id=?1",nativeQuery = true)
    void deleteLikesForAReply(@Param("replyId") Long replyId);

    void deleteAllByReplyId(Long likesForId);

    Boolean existsLikesByReplyId(Long replyId);

    // @Query(value="select * from likes l where l.likes_for=?1",nativeQuery = true)
    // Boolean isLiked(@Param("id") Long id);

}
