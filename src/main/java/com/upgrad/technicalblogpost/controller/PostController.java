package com.upgrad.technicalblogpost.controller;

import com.upgrad.technicalblogpost.model.Post;
import com.upgrad.technicalblogpost.model.User;
import com.upgrad.technicalblogpost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    public PostController(){
        System.out.println("*********** PostController ***********");
    }
    //localhost:8080/posts : GET
    @Autowired
    PostService postService;
    @RequestMapping("/posts")
    public String getUserPost(Model model,HttpSession session){
        User user = (User) session.getAttribute("loggeduser");
        List<Post> posts= postService.getAllPosts(user.getId());
        model.addAttribute("posts",posts);
        return "posts";
    }

    @RequestMapping("/posts/newpost")
    public String newPost(){
        return "posts/create";
    }

    @RequestMapping(value="/posts/create", method= RequestMethod.POST)
    public String createPost(Post newPost, HttpSession session){
        //pick the user
        User user = (User) session.getAttribute("loggeduser");
        newPost.setUser(user);
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";
    }


    @RequestMapping(value="/deletepost", method = RequestMethod.DELETE)
    public String deletePostSubmit(@RequestParam(name="postId") Integer postId){
        postService.deletePost(postId);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editpost", method = RequestMethod.GET)
    public String editPost(@RequestParam(value = "postId") Integer postId, Model model){
        Post post=postService.getPost(postId);
        model.addAttribute("post",post);
        return "posts/edit";
    }

    @RequestMapping(value = "/editpost", method = RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(value = "postId") Integer postId, Post updatedPost ,HttpSession session){
        updatedPost.setId(postId);
        User user = (User) session.getAttribute("loggeduser");
        updatedPost.setUser(user);
        postService.updatePost(updatedPost);
        return "redirect:/posts";
    }


}
