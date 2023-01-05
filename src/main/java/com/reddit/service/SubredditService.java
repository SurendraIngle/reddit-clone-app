package com.reddit.service;

import com.reddit.entity.Subreddit;
import com.reddit.repository.PostRepository;
import com.reddit.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SubredditService {
    @Autowired
    private SubredditRepository subredditRepository;


    public void createSubreddit(Subreddit subreddit, Long subredditId) {
       subredditRepository.save(subreddit);
    }

    public List<Subreddit> findAll() {
       return subredditRepository.findAll();
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
