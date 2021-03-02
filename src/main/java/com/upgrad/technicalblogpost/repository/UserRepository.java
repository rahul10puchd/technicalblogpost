package com.upgrad.technicalblogpost.repository;

import com.upgrad.technicalblogpost.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

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

}
