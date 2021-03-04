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
    public List<Post> getAllPosts(Integer userID){
        EntityManager em= emf.createEntityManager();
        TypedQuery<Post> query= em.createQuery("SELECT p from Post p join fetch p.user pu where pu.id= :userid", Post.class);
        query.setParameter("userid",userID);
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
    public void deletePost(Integer postID){
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction=em.getTransaction();//1
        try{
            transaction.begin();//2
            Post post = em.find(Post.class,postID);
            em.remove(post);
            transaction.commit();//3
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();//4
        }
    }
    public void updatePost(Post updatedPost){
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction=em.getTransaction();//1
        try{
            transaction.begin();//2
            em.merge(updatedPost);
            transaction.commit();//3
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();//4
        }
    }
    public Post getPost(Integer postId){
        EntityManager em=emf.createEntityManager();
        return em.find(Post.class,postId);
    }

}
