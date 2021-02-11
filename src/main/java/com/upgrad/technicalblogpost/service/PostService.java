package com.upgrad.technicalblogpost.service;

import com.upgrad.technicalblogpost.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    private static ArrayList<Post> POSTS=new ArrayList<Post>();
    static {
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

        POSTS.add(post1);
        POSTS.add(post2);
        POSTS.add(post3);
    }

    public ArrayList<Post> getAllPosts(){
        return POSTS;
    }
    public void createPost(Post newPost){
        POSTS.add(newPost);
    }
}
