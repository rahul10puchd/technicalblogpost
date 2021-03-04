package com.upgrad.technicalblogpost.service;

import com.upgrad.technicalblogpost.model.Post;
import com.upgrad.technicalblogpost.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    public PostService(){
        System.out.println("*********** PostService ***********");
    }
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts(Integer userID){
        return repository.getAllPosts(userID);
    }
    public void  createPost(Post newPost){
        Integer id=repository.createPost(newPost);
        System.out.println("done with create post with Id: "+id);
    }
    public void deletePost(Integer postID){
        repository.deletePost(postID);
    }
    public void updatePost(Post updatedPost){
        repository.updatePost(updatedPost);
    }
    public Post getPost(Integer postId){
        return repository.getPost(postId);
    }
}
