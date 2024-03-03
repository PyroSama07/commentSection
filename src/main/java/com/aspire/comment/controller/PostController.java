package com.aspire.comment.controller;

import com.aspire.comment.models.Post;
import com.aspire.comment.repository.CommentRepository;
import com.aspire.comment.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {

    CommentRepository commentRepository;
    PostRepository postRepository;
    @Autowired
    PostController(PostRepository postRepository, CommentRepository commentRepository){
        this.commentRepository=commentRepository;
        this.postRepository=postRepository;
    }

    @PostMapping("/addPost")
    public void addPosts(@RequestBody Post post){
        postRepository.save(post);
    }

    @GetMapping("/getPosts")
    public Iterable<Post> getPosts(){
        return postRepository.findAll();
    }
}
