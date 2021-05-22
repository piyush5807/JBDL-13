package com.example.gfg.libraryproject.students;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    private String name;
    private String email;
    private int age;

    private String username;
    private String password;
}
