package com.example.jbdl13.demojpasecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PersonConfig extends WebSecurityConfigurerAdapter {


    @Value("${my_app.person-admin.authority}")
    String ADMIN_PERSON_AUTHORITY;

    @Value("${my_app.person.authority}")
    String PERSON_AUTHORITY;

    @Autowired
    MyUserDetailsService service;

    // This function handles authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }

    // This function handles authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*

            if(request.startsWith("/))){
            }else if(){
            }else if(){
         */

        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").hasAuthority(PERSON_AUTHORITY)
                .antMatchers("/admin/**").hasAuthority(ADMIN_PERSON_AUTHORITY)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }


    @Bean
    PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
