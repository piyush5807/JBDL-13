package com.example.jbdl13.majorproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    public Wallet findByUserId(String userId);

//    @Modifying
//    @Transactional
//    @Query("update Wallet w set w.balance = w.balance + :amount where w.userId = :userId")
//    public void incrementWallet(String userId, int amount);
//
//    @Modifying
//    @Transactional
//    @Query("update Wallet w set w.balance = w.balance - :amount where w.userId = :userId")
//    public void decrementWallet(String userId, int amount);

    @Modifying
    @Transactional
    @Query("update Wallet w set w.balance = w.balance + :amount where w.userId = :userId")
    public void updateWallet(String userId, int amount);


}
