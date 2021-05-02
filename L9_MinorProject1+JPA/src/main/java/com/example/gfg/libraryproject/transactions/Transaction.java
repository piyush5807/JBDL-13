package com.example.gfg.libraryproject.transactions;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.students.Student;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId = UUID.randomUUID().toString();

    /*
        First part relates to the current class in which you are writing the annotation
        Second part relates to the field on top of which you are writing this annotation
    */
    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    private Student student;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    private Integer fine;
}
