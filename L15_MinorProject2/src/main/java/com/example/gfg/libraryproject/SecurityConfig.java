package com.example.gfg.libraryproject;

import com.example.gfg.libraryproject.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${my_app.admin.authority}")
    private String ADMIN_AUTHORITY;

    @Value("${my_app.student.authority}")
    private String STUDENT_AUTHORITY;

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/student/list/**").hasAuthority(ADMIN_AUTHORITY)
                .antMatchers(HttpMethod.POST, "/student/**").hasAuthority(ADMIN_AUTHORITY)
                .antMatchers(HttpMethod.DELETE, "/student/**").hasAuthority(ADMIN_AUTHORITY)
                .antMatchers("/student/**").hasAuthority(STUDENT_AUTHORITY)
                .antMatchers(HttpMethod.GET, "/book/**").hasAnyAuthority(STUDENT_AUTHORITY, ADMIN_AUTHORITY)
                .antMatchers("/book/**").hasAuthority(ADMIN_AUTHORITY)
                .antMatchers("/transaction/**").hasAuthority(STUDENT_AUTHORITY)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    PasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
}
