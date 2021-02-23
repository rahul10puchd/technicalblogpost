package com.upgrad.technicalblogpost.repository;

import com.upgrad.technicalblogpost.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class UserRepositoryImpl implements UserRepository{

    public List<User> findByUserName(String userName) {
        return findByUserName(userName);
    }
}
