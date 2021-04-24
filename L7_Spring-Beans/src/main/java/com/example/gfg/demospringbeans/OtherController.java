package com.example.gfg.demospringbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Util;


@RestController
public class OtherController{

    @Autowired
    MyConfig myConfig;

//    @Value("${my_app.cost}")
//    int cost;
//
//    @GetMapping("/cost")
//    public int getCost(){
//        return cost;
//    }

    OtherController(){
//        this.utils = utils;
//        this.utils.setCount(20);
//        System.out.println(this.utils.getCount());
//        this.cost = cost;
        System.out.println("Creating OtherController object = " + this);
    }

    @GetMapping("/test")
    public void testFunction(){
//        Utils utils = new Utils();
        Utils utils = myConfig.getObject();
//        Utils utils = new Utils();
        System.out.println("In OtherController: utils = " + utils);
        utils.testFunc(OtherController.class);
        System.out.println(utils.getCount());
        utils.setCount(utils.getCount() + 10);
        System.out.println(utils.getCount());

        Utils utils1 = new Utils();
        System.out.println("utils object created manually - " + utils1);
    }

//    @GetMapping("/encode/{message}")
//    public String encode(@PathVariable("message") String message){
//
//        BCryptPasswordEncoder bCryptPasswordEncoder = (BCryptPasswordEncoder) myConfig.getPE();
//        System.out.println(bCryptPasswordEncoder);
//        return bCryptPasswordEncoder.encode(message);
//    }
}