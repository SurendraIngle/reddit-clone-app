package com.reddit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
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
    @NotBlank(message = "Desciption is required")
    private String description;
    @CreationTimestamp
    private Timestamp createdDate;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "subreddit")
    private List<Post> posts;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
