package com.example.jbdl13.demojpasecurity;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {


    @GetMapping("/user")
    public Person getPerson(@RequestParam("user") String name, @RequestParam("age") int age){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Person.builder()
                .name(name)
                .age(age)
                .isAdmin(false)
                .build();
    }

    @GetMapping("/admin")
    public Person getAdminPerson(@RequestParam("user") String name, @RequestParam("age") int age){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Person.builder()
                .name(name)
                .age(age)
                .isAdmin(true)
                .build();

    }

    @GetMapping("/")
    public String welcomePerson(@RequestParam("user") String user){
        return "Welcome User : " + user + "!!!";
    }




}
