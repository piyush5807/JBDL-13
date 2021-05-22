package com.example.gfg.libraryproject;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.books.BookRepository;
import com.example.gfg.libraryproject.books.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryProjectApplicationTests {

	@Mock // @Autowired
	private BookRepository bookRepository;


	@Test
	void contextLoads() {
	}
}
