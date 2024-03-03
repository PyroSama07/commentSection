package com.aspire.comment.controller;

import com.aspire.comment.models.Comment;
import com.aspire.comment.repository.CommentRepository;
import com.aspire.comment.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    CommentRepository commentRepository;
    PostRepository postRepository;
    @Autowired
    CommentController(PostRepository postRepository, CommentRepository commentRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/addComment")
    public void addComment(@RequestParam String body, @RequestParam int postId, @RequestParam int parentCommentId){
        Comment comment = new Comment();
        comment.setBody(body);
        comment.setPostId(postId);
        comment.setParentCommentId(parentCommentId);
        commentRepository.save(comment);
    }

    @GetMapping("/getComments")
    public Comment getComments(@RequestParam int postId){
        List<Comment> comments = commentRepository.getCommentsOfPost(postId);
        HashMap<Integer, Comment> commentsSet = new HashMap<>();
        Comment rootComment = new Comment();
        rootComment.setCommentId(-1);
        rootComment.setReplies(new HashSet<>());
        commentsSet.put(-1,rootComment);

        for (Comment comment:comments){
            int id = comment.getCommentId();
            comment.setReplies(new HashSet<>());
            commentsSet.put(id,comment);
        }

        for (Map.Entry<Integer,Comment> commentEntry : commentsSet.entrySet()){
            Comment comment = commentEntry.getValue();
            Comment parent = commentsSet.get(comment.getParentCommentId());
            if (parent==null) continue;
            HashSet<Comment> replies = parent.getReplies();
            replies.add(comment);
            parent.setReplies(replies);
        }
        return rootComment;
    }
}
