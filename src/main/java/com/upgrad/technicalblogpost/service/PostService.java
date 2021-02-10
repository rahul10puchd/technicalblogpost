package com.upgrad.technicalblogpost.service;

import com.upgrad.technicalblogpost.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<Post> getAllPosts(){
        ArrayList<Post> posts = new ArrayList<>();

        Post post1= new Post();
        post1.setTitle("Boring Post");
        post1.setBody("Boring Bodyyyyyyyyyyyyy");
        post1.setDate(new Date());
        posts.add(post1);
        return posts;
    }
}
