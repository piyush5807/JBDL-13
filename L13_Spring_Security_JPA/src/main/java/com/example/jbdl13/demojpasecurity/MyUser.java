package com.example.jbdl13.demojpasecurity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// PERSON:PERSON_ADMIN

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MyUser implements UserDetails {

    private static final String AUTHORITY_DELIMITER = ":";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;
    private String authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[]authoritiesArray = this.authorities.split(AUTHORITY_DELIMITER);

        return Arrays.stream(authoritiesArray)
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        for(String authority : authoritiesArray){
//            authorityList.add(new SimpleGrantedAuthority(authority));
//        }
//
//        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
