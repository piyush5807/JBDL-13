package com.example.gfg.libraryproject.transactions;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public void issueBook(@RequestParam("student_id") int student_id,
                          @RequestParam("book_id") int book_id){


        // update book table with the given student object
        // make an entry in the transaction table also

        transactionService.issueBook(book_id, student_id);
    }


    @PostMapping("/return")
    public void returnBook(@RequestParam("student_id") int student_id,
                           @RequestParam("book_id") int book_id){

        // update book table with student as null
        // make an entry in the transaction table

        transactionService.returnBook(book_id, student_id);
    }

    // CSV file which contains the list of transactions for a particular user
    @GetMapping(value = "/transaction_details", produces = MediaType.TEXT_PLAIN_VALUE)
    public byte[] generateTransactionsFile(@RequestParam("studentId") int studentId){

        // dont include primary key id in this, include transactionId and other details
        return null;
    }
}
