package com.reddit.controller;

import com.reddit.entity.Post;
import com.reddit.entity.Subreddit;
import com.reddit.service.PostService;
import com.reddit.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private SubredditService subredditService;

    @Autowired
    private PostService postService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/newPost")
    public String createNewPost(Model model){
        Post post = new Post();
        List<Subreddit> subreddits = subredditService.findAll();
        model.addAttribute("post", post);
        model.addAttribute("subreddits", subreddits);
        return "new-post";
    }

    @PostMapping("/saveOrUpdatePost")
    public String saveOrUpdatePost(@ModelAttribute("post") Post post, @RequestParam("subreddit") String  subredditId){
        Subreddit subreddit = subredditService.getSubredditById(Long.parseLong(subredditId));
        postService.addPost(post);
        return "redirect:/post/" + post.getId();
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable("id") int postId, Model model){
        Post post  = postService.getPostById((long)postId);
        return "view-post";
    }
}
