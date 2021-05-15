package com.example.jbdl13.demojpasecurity;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private int age;
    private boolean isAdmin;

}