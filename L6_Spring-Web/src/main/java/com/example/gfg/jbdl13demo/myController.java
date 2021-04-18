package com.example.gfg.jbdl13demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

    @RequestMapping(value = "/greet", method = RequestMethod.POST)
    public String greetPerson(@RequestParam(value = "my_name", required = false, defaultValue = "user") String name){
        return "Hello " + name + "!!!";
    }

}
