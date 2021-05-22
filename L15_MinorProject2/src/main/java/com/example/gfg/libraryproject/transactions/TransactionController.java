package com.example.gfg.libraryproject.transactions;

import com.example.gfg.libraryproject.user.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction/issue")
    public String issueBook(@RequestParam("book_id") int book_id) throws Exception {


        // update book table with the given student object
        // make an entry in the transaction table also

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        com.example.gfg.libraryproject.user.User user = (User) authentication.getPrincipal();

        return "Your transaction succeeded, here is the transactionId" + transactionService.issueBook(book_id, user);
    }


    @PostMapping("/transaction/return")
    public String returnBook(@RequestParam("student_id") int student_id,
                           @RequestParam("book_id") int book_id) throws Exception {

        // update book table with student as null
        // make an entry in the transaction table

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        com.example.gfg.libraryproject.user.User user = (User) authentication.getPrincipal();

        return "Your transaction succeeded, here is the transactionId " + transactionService.returnBook(book_id, user);
    }

    // CSV file which contains the list of transactions for a particular user
    @GetMapping(value = "/transaction_details", produces = MediaType.TEXT_PLAIN_VALUE)
    public byte[] generateTransactionsFile(@RequestParam("studentId") int studentId){

        // dont include primary key id in this, include transactionId and other details
        return null;
    }
}
