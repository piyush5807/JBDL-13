package com.example.jbdl13.demosecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class UserConfig extends WebSecurityConfigurerAdapter {

    // Role are nothing but an authority with ROLE_ prefix

    @Value("${my_app.admin.authority}")
    String ADMIN_AUTHORITY;

    @Value("${my_app.user.authority}")
    String USER_AUTHORITY;


    // This function handles authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("john")
                .password("$2a$10$7r0ORdggKCduoDxpHw8ZAuIv/YZaWRMn6PrwbwTlwU1.Ra2JWox/i")
                .authorities(USER_AUTHORITY)
                .and()
                .withUser("peter")
                .password("$2a$10$2j5pUkJGGbtVJ5tNQ/rjTuT3LL1M5eg1JSdiQ6l4i7TjNYzVls49y")
                .authorities(ADMIN_AUTHORITY)
                .and()
                .withUser("william")
                .password("$2a$10$vv8jC6nEwcnSMWmoa.S2N.EXFMhIYZfSqbqv7WHI/yP81WMmcfRsu")
                .roles()
                .authorities(ADMIN_AUTHORITY, USER_AUTHORITY);
    }

    // This function handles authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*

            if(request.startsWith("/))){
            }else if(){
            }else if(){
         */

        http.authorizeRequests()
                .antMatchers("/user/**").hasAuthority(USER_AUTHORITY)
                .antMatchers("/admin/**").hasAuthority(ADMIN_AUTHORITY)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }


    @Bean
    PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
