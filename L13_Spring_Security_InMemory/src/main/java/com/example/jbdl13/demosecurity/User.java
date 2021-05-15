package com.example.jbdl13.demosecurity;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private int age;
    private boolean isAdmin;

}
