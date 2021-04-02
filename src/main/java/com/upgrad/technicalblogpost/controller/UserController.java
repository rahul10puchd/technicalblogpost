package com.upgrad.technicalblogpost.controller;

import com.upgrad.technicalblogpost.model.Post;
import com.upgrad.technicalblogpost.model.User;
import com.upgrad.technicalblogpost.repository.UserRepository;
import com.upgrad.technicalblogpost.service.PostService;
import com.upgrad.technicalblogpost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/user")
public class UserController {
    // URL : users/login
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postservice;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("users/login") //localhost:8080/users/login : GET
    public String login(Model model){
        model.addAttribute("user", new User());
        return "users/login";
    }


    @RequestMapping(value="users/login", method= RequestMethod.POST)  // localhost:8080/users/login : POST
    public String loginUser(User user){
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        if(userService.login(user)){
            return "redirect:/posts"; //localhost:8080/posts : GET
        }else{
            return "users/login"; //localhost:8080/users/login : GET
        }
    }


    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(value="users/registration", method= RequestMethod.POST)
    public String registerUser(User user){
        System.out.println(user.getFullName());
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        //TODO : service code to register the user so that you can login with that creds
        return "redirect:/users/login";
    }
    //TODO: logout feature: done
    public String logout(Model model){
        List<Post> post=postservice.getAllPosts();
        model.addAttribute("posts",post);
        return "redirect:index";
    }

    @GetMapping("/{user}")
    public List<User> getUserByUserName(@PathVariable("user") final String userName) {
        return userRepository.findByUserName(userName);
    }

    @GetMapping("/gellAllUsers")
    public List<User> getAllusers() {
        return userRepository.findAll();
    }

    @RequestMapping(value="/createUser", method= RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<User> searchUsersByPattern(@RequestParam("keyword") String keyword) {
        return userRepository.findByUserNameIgnoreCaseContaining(keyword);
    }

}
