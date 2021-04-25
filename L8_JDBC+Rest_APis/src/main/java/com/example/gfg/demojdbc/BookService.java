package com.example.gfg.demojdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() throws SQLException {
        return bookRepository.findAllBooks();
    }

    public Book getBookById(int bookId) throws SQLException {
        return bookRepository.findByBookId(bookId);
    }

    public void insertBook(Book book) throws SQLException {
        bookRepository.insertBook(book);
    }

    public void deleteBook(int bookId){
    }

    public void updateBook(int bookId, Book book){

    }
}
