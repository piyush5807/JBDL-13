package com.example.gfg.libraryproject.transactions;

import com.example.gfg.libraryproject.books.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    BookService bookService;

    @Autowired
    TransactionRepository transactionRepository;

    public void issueBook(int bookId, int studentId){

    }

    public void returnBook(int bookId, int studentId){

    }
}
