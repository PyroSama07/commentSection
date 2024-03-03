package com.aspire.comment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter

@Entity
@Table (name="post")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "post_id")
    int postId;
    String url;
    String caption;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "fk_post_id",referencedColumnName = "post_id")
//    List<Comment> comments;
}
