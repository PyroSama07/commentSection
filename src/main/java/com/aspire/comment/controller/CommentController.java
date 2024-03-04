package com.aspire.comment.controller;

import com.aspire.comment.models.Comment;
import com.aspire.comment.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/comment")
public class CommentController {

    CommentRepository commentRepository;
    @Autowired
    CommentController(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }

    @PostMapping("/addComment")
    public void addComment(@RequestBody Comment comment){
        commentRepository.save(comment);
    }

    @GetMapping("/getAllComments")
    public Iterable<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    @PostMapping("/deleteComment")
    public void deleteComment(@RequestParam int id){
        commentRepository.deleteById(id);
    }

    @GetMapping("/getComment")
    public Optional<Comment> getComment(@RequestParam int id){
        return commentRepository.findById(id);
    }

    @PostMapping("/deleteAllComments")
    public void deleteAllComments(){
        commentRepository.deleteAll();
    }
}
