package com.example.gfg.libraryproject.transactions;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.books.BookService;
import com.example.gfg.libraryproject.students.Student;
import com.example.gfg.libraryproject.students.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    private static Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${books.max-allowed}")
    private int max_books_allowed;

    @Value("${books.no-of-days-allowed}")
    private int no_of_days_allowed;

    @Value("${books.fine-per-day}")
    private int fine_per_day;

    public String issueBook(int bookId, int studentId) throws Exception{

        Book book = bookService.getBookById(bookId);
        Student student = studentService.getStudentById(studentId);

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.ISSUE)
                .book(book)
                .student(student)
                .transactionId(UUID.randomUUID().toString())
                .build();

        if(book == null || book.getMy_student() != null){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setRemarks("Book not present");
            transactionRepository.save(transaction);
            logger.error("book with id {} either doesn't exist or is " +
                    "assigned to someone else", bookId);
            throw new Exception("Book cannot be issued");
        }

        if(student == null){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setRemarks("Invalid Student");
            transactionRepository.save(transaction);
            logger.error("student with id {} is invalid", studentId);
            throw new Exception("Student not valid");
        }

        if(student.getBooks().size() >= max_books_allowed){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setRemarks("Books threshold reached");
            transactionRepository.save(transaction);
            logger.error("student {} has reached maximum value of books issued", studentId);
            throw new Exception("Student reached maximum Threshold");
        }


        book.setMy_student(student);

        bookService.createBook(book);

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setRemarks("Issuing book");

        Transaction tr = transactionRepository.save(transaction);
        return tr.getTransactionId();
    }

    public String returnBook(int bookId, int studentId) throws Exception {
//        Book book = bookService.getBookById(bookId);
//        Student student = studentService.getStudentById(studentId);

        List<Transaction> allTransactions = transactionRepository.getTransaction(bookId, studentId,
                TransactionType.ISSUE, TransactionStatus.SUCCESS);

        if (allTransactions == null || allTransactions.size() == 0){
            logger.error("Could not found any issue transaction for bookId {}, " +
                    "studentId {}", bookId, studentId);
            throw  new Exception("Record of issue transaction could not be found");
        }

        Transaction transaction = allTransactions.get(0);

        Book book = transaction.getBook();
        Student student = transaction.getStudent();

        Date transactionDate = transaction.getTransactionDate();
        long timeInMillis = System.currentTimeMillis() - transactionDate.getTime();
        long daysPassed = TimeUnit.DAYS.convert(timeInMillis, TimeUnit.MILLISECONDS);

        int fine = 0;
        if((int)daysPassed > no_of_days_allowed){
            fine = ((int)daysPassed - no_of_days_allowed) * fine_per_day;
        }

        book.setMy_student(null);
        bookService.createBook(book);

        Transaction returnTr = Transaction.builder()
                .student(student)
                .book(book)
                .fine(fine)
                .transactionType(TransactionType.RETURN)
                .transactionStatus(TransactionStatus.SUCCESS)
                .remarks("Returned Successfully with fine " + fine)
                .transactionId(UUID.randomUUID().toString())
                .build();

        returnTr = transactionRepository.save(returnTr);

        return returnTr.getTransactionId();
    }
}
