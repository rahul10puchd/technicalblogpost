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
    public boolean login(User user){
        if(user.getUsername().equals("admin") && user.getPassword().equals("admin123")){
            return true;
        }else{
            return false;
        }

    }

    public void registerUser(User newUser){
        repository.register(newUser);
    }
}
