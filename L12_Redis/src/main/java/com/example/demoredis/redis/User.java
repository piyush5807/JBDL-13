package com.example.demoredis.redis;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private int id;
    private String name;
    private String country;
    private int age;

}
