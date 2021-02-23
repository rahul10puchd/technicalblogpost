package com.upgrad.technicalblogpost.repository;

import com.upgrad.technicalblogpost.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByUserName(String userName);

}
