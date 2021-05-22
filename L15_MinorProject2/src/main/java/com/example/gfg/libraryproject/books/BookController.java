package com.example.gfg.libraryproject.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {


    @Autowired
    BookService bookService;

    @GetMapping("/book/list")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBooks(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @PostMapping("/bookByDTO")
    public void saveBookByDTO(@RequestBody BookRequest bookRequest){
        Book book = bookRequest.createBook();
        bookService.createBook(book);
    }

    @GetMapping("/book/name")
    public List<Book> getBookByName(@RequestParam("name") String name){
        return bookService.getBookByName(name);
    }

}
