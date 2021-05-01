package com.example.gfg.libraryproject.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

//    public Book getBookByCompositeId(int bookId, String name){
//        PrimaryCompKey primaryCompKey = new PrimaryCompKey(bookId, name);
//        return bookRepository.findById(primaryCompKey).orElse(null);
//    }

    public Book getBookById(int bookId){
        return bookRepository.findById(bookId).orElse(null);
    }
}
