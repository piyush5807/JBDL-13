package com.example.jbdl13.demosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/user")
    public User getUser(@RequestParam("user") String name, @RequestParam("age") int age){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return User.builder()
                .name(name)
                .age(age)
                .isAdmin(false)
                .build();
    }

    @GetMapping("/admin")
    public User getAdmin(@RequestParam("user") String name, @RequestParam("age") int age){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return User.builder()
                .name(name)
                .age(age)
                .isAdmin(true)
                .build();

    }

    @GetMapping("/")
    public String welcomeUser(@RequestParam("user") String user){
        return "Welcome User : " + user + "!!!";
    }




}
