package com.reddit.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
<<<<<<< HEAD
import org.hibernate.annotations.UpdateTimestamp;
=======
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
>>>>>>> fdebc048a1676e7ac15624f86f054beac27b74a1
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Community name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @CreationTimestamp
    private Timestamp createdDate;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "subreddit")
    private List<Post> posts;

    private List<User> user;

}
