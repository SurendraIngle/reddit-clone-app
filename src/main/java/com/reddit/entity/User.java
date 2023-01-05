package com.reddit.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role="ROLE_USER";
    @Column(name="created_at",nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    private boolean enabled;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "subreddit_user",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="subreddit_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Subreddit> subreddits;
    @OneToMany(fetch = LAZY,mappedBy = "user")
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    List<Comment> comments;
}
