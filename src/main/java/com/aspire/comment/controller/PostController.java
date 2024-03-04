package com.aspire.comment.controller;

import com.aspire.comment.models.Post;
import com.aspire.comment.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {

    PostRepository postRepository;
    @Autowired
    PostController(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    @PostMapping("/addPost")
    public void addPosts(@RequestBody Post post){
        postRepository.save(post);
    }

    @GetMapping("/getAllPosts")
    public Iterable<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @GetMapping("getPost")
    public Optional<Post> getPost(int postId){
        return postRepository.findById(postId);
    }
    @PostMapping("/deleteALlPosts")
    public void deleteAllPosts(){
        postRepository.deleteAll();
    }

    @PostMapping("/deletePost")
    public void deletePost(int postId){
        postRepository.deleteById(postId);
    }
}
