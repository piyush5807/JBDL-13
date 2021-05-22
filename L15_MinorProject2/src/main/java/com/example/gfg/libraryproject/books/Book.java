package com.example.gfg.libraryproject.books;

import com.example.gfg.libraryproject.students.Student;
import com.example.gfg.libraryproject.transactions.Transaction;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(PrimaryCompKey.class)
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String author;
    private int cost;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Student my_student;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions;

}
