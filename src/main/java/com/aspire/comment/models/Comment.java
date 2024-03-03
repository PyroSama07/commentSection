package com.aspire.comment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="comment_id")
    int commentId;
    String body;
    @Column(name="parent_comment_id")
    int parentCommentId;
    @Column(name="post_id")
    int postId;

    @Transient
    HashSet<Comment> replies;

//    @ManyToOne(fetch = FetchType.LAZY, optional=true)
//    @JoinColumn(name="parent_id")
//    Comment parent;
//
//    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
//    List<Comment> children;
//    @JsonIgnore
//    public List<Comment> getChildren() {
//        return children;
//    }
}
