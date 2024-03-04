package com.aspire.comment.repository;

import com.aspire.comment.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {
}
