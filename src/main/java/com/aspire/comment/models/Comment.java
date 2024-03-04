package com.aspire.comment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    int commentId;
    String body;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name="parent_comment_id",referencedColumnName = "comment_id")
    Comment parent;

    @OneToMany(mappedBy = "parent")
    List<Comment> replies;

    @ManyToOne
    @JoinColumn(name = "fk_post_id",referencedColumnName = "post_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Post post;

    @JsonIgnore
    Comment getParent(){
        return parent;
    }

    @JsonIgnore
    Post getPost(){
        return post;
    }
}
