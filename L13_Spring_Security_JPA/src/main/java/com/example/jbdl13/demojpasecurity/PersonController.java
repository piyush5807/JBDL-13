package com.example.jbdl13.demojpasecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @Autowired
    PasswordEncoder encoder;

    @Value("${my_app.person-admin.authority}")
    String ADMIN_PERSON_AUTHORITY;

    @Value("${my_app.person.authority}")
    String PERSON_AUTHORITY;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PostMapping("/signup")
    public void signup(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("is_admin") boolean isAdmin){

        String authority = isAdmin ? ADMIN_PERSON_AUTHORITY : PERSON_AUTHORITY;

        MyUser user = MyUser.builder()
                .username(username)
                .password(encoder.encode(password))
                .authorities(authority)
                .build();

//        try{
            myUserDetailsService.saveUser(user);
//        }catch (DuplicateKeyException e){
//
//        }
    }


}
