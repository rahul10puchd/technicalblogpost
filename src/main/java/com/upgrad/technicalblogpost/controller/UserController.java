package com.upgrad.technicalblogpost.controller;

import com.upgrad.technicalblogpost.model.User;
import com.upgrad.technicalblogpost.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    // URL : users/login
    private UserService userService=new UserService();
    @RequestMapping("users/login") //localhost:8080/users/login : GET
    public String login(Model model){
        model.addAttribute("user", new User());
        return "users/login";
    }
    @RequestMapping(value="users/login", method= RequestMethod.POST)  // localhost:8080/users/login : POST
    public String loginUser(User user){
        System.out.println("helooooooooooooooooooooooooooooooooooooooooooooo");
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
        //TODO : service code to register the user so that you can login with that creds
        return "redirect:/users/login";
    }

}
