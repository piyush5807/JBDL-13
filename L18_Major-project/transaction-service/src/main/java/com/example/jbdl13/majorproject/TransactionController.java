package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public void transferMoney(@RequestBody TransactionRequest transactionRequest) throws JsonProcessingException {

        if (transactionRequest.isValidRequest()) {
            transactionService.createTransaction(transactionRequest);
        }
    }
}
