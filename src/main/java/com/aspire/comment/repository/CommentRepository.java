package com.aspire.comment.repository;

import com.aspire.comment.models.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer> {

    @Query(value = "Select * from comment where post_id=:postId",nativeQuery = true)
    List<Comment> getCommentsOfPost(@Param("postId") int postId);

}
