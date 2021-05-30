package com.example.jbdl13.majorproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("update Transaction t set t.transactionStatus =:transactionStatus where t.transactionId =:trId")
    @Modifying
    @Transactional
    public void updateTransactionStatus(String trId, TransactionStatus transactionStatus);

    Transaction findByTransactionId(String transactionId);
}
