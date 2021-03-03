package com.upgrad.technicalblogpost.repository;

import com.upgrad.technicalblogpost.model.Post;
import com.upgrad.technicalblogpost.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public void register(User newUser){
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction=em.getTransaction();//1
        try{
            transaction.begin();//2
            em.persist(newUser);
            transaction.commit();//3
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();//4
        }
        return;
    }
    public User checkUser(String username, String password){
        try{
            EntityManager em= emf.createEntityManager();
            TypedQuery<User> query= em.createQuery("SELECT u from User u Where u.username= :username AND u.password= :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        }catch (NoResultException nre){
            return null;
        }

    }
}
