package com.upgrad.technicalblogpost.controller;

import com.upgrad.technicalblogpost.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
//1. Controller -> RestController
@RestController
public class HomeController {
    @RequestMapping("/api/getposts")
    //2.We don't require Model anymore...so delete it
    public ArrayList<Post> getAllPosts(){//5. correct the return type of the function

        ArrayList<Post> posts = new ArrayList<>();

        Post post1= new Post();
        post1.setTitle("Mirzapur");
        post1.setBody("Kalin Bhaia ki sarkar");
        post1.setDate(new Date());

        Post post2= new Post();
        post2.setTitle("Gangs of Wassepur");
        post2.setBody("Keh ke lenege");
        post2.setDate(new Date());

        Post post3= new Post();
        post3.setTitle("Kissan");
        post3.setBody("Modi ke sarkar");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        //3. delete model.addAttribute also

        return posts;//4. returning posts
    }
//6. create a getpost by username API
    @RequestMapping("/api/getposts/{user1}")
    public Post getPostByUserName(@PathVariable(value = "user1") String user){
        Post post1= new Post();
//        if (user.equals("rahul")){
            post1.setTitle("Mirzapur");
            post1.setBody("Kalin Bhaia ki sarkar");
            post1.setDate(new Date());

        return post1;
    }
}
