package com.example.gfg.demospringbeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.rmi.CORBA.Util;
import java.util.Arrays;

@RestController
public class MyController {

    private static Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    static Utils utils;

    @GetMapping("/greet")
    public void testFunction(){
        System.out.println("utils object = " + utils);
        utils.testFunc(MyController.class);
        System.out.println(utils.getCount());
    }

    @GetMapping("/logs")
    public void logging(@RequestParam("name") String name){
        logger.error("Some error occurred - {}", name);
        logger.warn("Some warn occurred - {}", name);
        logger.info("Some info occurred - {}", name);
        logger.debug("Some debug occurred - {}", name);
        logger.trace("Some trace occurred - {}", name);

    }

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/beans")
    public void getBeans(){
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(x -> logger.info("bean - {}", x));
    }

}
