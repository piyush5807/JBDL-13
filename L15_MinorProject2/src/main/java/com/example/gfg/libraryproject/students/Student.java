package com.example.gfg.libraryproject.students;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.transactions.Transaction;
import com.example.gfg.libraryproject.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int age;
    private String email;

    @OneToMany(mappedBy = "my_student", cascade = CascadeType.ALL)
    private List<Book> books;

    @OneToMany(mappedBy = "student")
    private List<Transaction> transactions;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties({"student", "password", "accountNonExpired",
            "accountNonLocked", "credentialsNonExpired", "enabled"})
    private User user;

}
