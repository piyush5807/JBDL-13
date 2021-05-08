package com.example.gfg.libraryproject.transactions;

import com.example.gfg.libraryproject.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


    // TODO:Try using the native query with limit 1 instead of the JPQL
    @Query("select t from Transaction t where t.book.id= ?1 and " +
            "t.student.id = ?2 and t.transactionType = ?3 and t.transactionStatus = ?4 order by t.id")
    public List<Transaction> getTransaction(int bookId, int studentId,
                                            TransactionType transactionType,
                                            TransactionStatus status);

}
