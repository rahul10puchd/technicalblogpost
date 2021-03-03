package com.upgrad.technicalblogpost.service;

import com.upgrad.technicalblogpost.model.User;
import com.upgrad.technicalblogpost.repository.PostRepository;
import com.upgrad.technicalblogpost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserService(){
        System.out.println("*********** UserService ***********");
    }
    @Autowired
    private UserRepository repository;
    public User login(User user){
        User existingUser = repository.checkUser(user.getUsername(),user.getPassword());
        if(existingUser!=null){
            return existingUser;
        }else{
            return null;
        }
    }

    public void registerUser(User newUser){
        repository.register(newUser);
    }
}
