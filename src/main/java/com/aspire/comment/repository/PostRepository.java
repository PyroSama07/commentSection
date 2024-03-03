package com.aspire.comment.repository;

import com.aspire.comment.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {
}
