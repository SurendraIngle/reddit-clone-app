package com.reddit.service;

import com.reddit.entity.Subreddit;
import com.reddit.repository.PostRepository;
import com.reddit.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

@Service
public class SubredditService {
    @Autowired
    private SubredditRepository subredditRepository;


    public void createSubreddit(Subreddit subreddit, Long subredditId) {
     subreddit.setCreatedDate(Timestamp.from(Instant.now()));

        subredditRepository.save(subreddit);
    }

    public List<Subreddit> findAll() {
       return subredditRepository.findAll();
    }

    public void deleteSubredditById(Long subredditId) {
    subredditRepository.deleteById(subredditId);
    }

    public Subreddit findById(Long subredditId) {
        return subredditRepository.findById(subredditId).get();
    }

    public Subreddit getSubredditById(long subredditId){
        Optional<Subreddit> result = subredditRepository.findById(subredditId);
        Subreddit subreddit = null;
        if (result != null){
            subreddit = result.get();
        }
        return subreddit;
    }
}
