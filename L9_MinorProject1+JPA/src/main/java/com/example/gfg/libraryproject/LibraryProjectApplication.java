package com.example.gfg.libraryproject;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.books.BookRepository;
import com.example.gfg.libraryproject.books.Genre;
import com.example.gfg.libraryproject.students.Student;
import com.example.gfg.libraryproject.students.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LibraryProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	BookRepository bookRepository;

	private static Logger logger = LoggerFactory.getLogger(LibraryProjectApplication.class);

	@Override
	public void run(String... args) throws Exception {

//		Book book = Book.builder()
//				.name("Plantation and Geography")
//				.author("Gregory")
//				.cost(1000)
//				.genre(Genre.FICTIONAL)
//				.build();
//
//		bookRepository.save(book);
//
////		Book bookBySQL = bookRepository.getBookByNameUsingSQL("Plantation and Geography");
//		List<Book> bookByJPQL = bookRepository.getBookByNameUsingJPQL("Plantation and Geography");
//
//		bookByJPQL.stream().forEach(b -> {
//				logger.info("book by JPQL is - name = {}, author = {}, cost = {}",
//						b.getName(), b.getAuthor(), b.getCost());
//		});


//		logger.info("book by SQL is - name = {}, author = {}, cost = {}",
//				bookBySQL.getName(), bookBySQL.getAuthor(), bookBySQL.getCost());


//		Student student = Student.builder()
//				.name("Roger")
//				.age(40)
//				.email("roger@gmail.com")
//				.build();
//
//		studentRepository.save(student);
//
//		Student student1 = studentRepository.getStudentForEmailBySQL("roger@gmail.com");

//		logger.info("student retrieved from find query is - name = {}, age = {}, email = {}",
//				student1.getName(), student1.getAge(), student1.getEmail());

	}
}
