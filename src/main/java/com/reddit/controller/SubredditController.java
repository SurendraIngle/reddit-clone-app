package com.reddit.controller;

import com.reddit.entity.Subreddit;
import com.reddit.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class SubredditController {
    @Autowired
    private SubredditService subredditService;

    @GetMapping("/home/add")
    public String create(Model model){
        model.addAttribute("subreddit",new Subreddit());
        return "saveSubreddit";
    }
    @PostMapping("/home/addSubreddit")
    public String createSubreddit(@ModelAttribute("subreddit")Subreddit subreddit, @RequestParam(value = "subredditId",required = false) Long subredditId){
        subredditService.createSubreddit(subreddit,subredditId);
       return "redirect:/home/";
    }
    @GetMapping("/showSubreddit")
    public List<Subreddit> showSubreddit(){
       return subredditService.findAll();

    }
    @GetMapping("/deleteSubreddit")
    public String deleteSubreddit(@RequestParam("subredditId") Long subredditId){
        subredditService.deleteSubredditById(subredditId);
        return "";
    }
    @GetMapping("/showSubredditId")
    public Subreddit showSubredditById(@RequestParam("subredditId")Long subredditId){
        Subreddit subreddit =subredditService.findById(subredditId);
        return  subreddit;
    }

}
