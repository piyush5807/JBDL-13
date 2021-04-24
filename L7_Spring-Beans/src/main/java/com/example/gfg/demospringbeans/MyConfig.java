package com.example.gfg.demospringbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyConfig {

    @Bean
    @Scope("prototype")
    public Utils getObject(){
        Utils utils = new Utils();
        System.out.println("In MyConfig class, Creating a new object " + utils);
        return utils;
    }

//    @Bean
//    public PasswordEncoder getPE(){
//        return new BCryptPasswordEncoder();
//    }
}


// com.example.gfg.demospringbeans.Utils@34567c67
// com.example.gfg.demospringbeans.Utils@2e397019
// com.example.gfg.demospringbeans.Utils@2604388