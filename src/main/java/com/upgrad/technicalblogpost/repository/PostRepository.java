package com.upgrad.technicalblogpost.repository;

import com.upgrad.technicalblogpost.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {
    public PostRepository(){
        System.out.println("*********** PostRepository ***********");
    }
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;
    public List<Post> getAllPosts(){
        EntityManager em= emf.createEntityManager();
        TypedQuery<Post> query= em.createQuery("SELECT p from Post p", Post.class);
        List<Post> result=query.getResultList();
        return result;
    }
    public Integer  createPost(Post newPost){
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction=em.getTransaction();//1
        try{
            transaction.begin();//2
            em.persist(newPost);
            transaction.commit();//3
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();//4
        }
        return newPost.getId();
    }
}
