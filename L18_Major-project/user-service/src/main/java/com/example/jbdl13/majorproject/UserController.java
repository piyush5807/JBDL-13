package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody User user) throws JsonProcessingException {
        userService.createUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable("userId") String userId){
       return userService.getUser(userId);
    }
}
