package com.example.gfg.demojdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping(value = "/books") // fetch / retrieve GET HTTP Method
    public List<Book> getAllBooks() throws SQLException {
        return bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")
    public Book getBookByBookId(@PathVariable("bookId") int bookId) throws SQLException {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/book") // posts / saves some data on server
    public void saveBook(@RequestBody Book book) throws SQLException {
        bookService.insertBook(book);
    }

    @DeleteMapping("/book") // deletes some data on the server
    public void deleteBookByBookId(@RequestParam("bookId") int bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping("/book") // updates the data on the server
    public void updateBookByBookId(@RequestParam("bookId") int bookId,
                                   @RequestBody Book book){
        bookService.updateBook(bookId, book);
    }


//    @GetMapping("/test")
//    public String testFunction(@RequestBody Book book){
//        logger.info("book - {}", book);
//        return "Okay got the book, thank you";
//    }

}
