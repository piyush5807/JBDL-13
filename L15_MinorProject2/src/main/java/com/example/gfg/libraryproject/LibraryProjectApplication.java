package com.example.gfg.libraryproject;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.books.BookRepository;
import com.example.gfg.libraryproject.books.Genre;
import com.example.gfg.libraryproject.students.Student;
import com.example.gfg.libraryproject.students.StudentRepository;
import com.example.gfg.libraryproject.user.User;
import com.example.gfg.libraryproject.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibraryProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;


	@Value("${my_app.admin.authority}")
	private String ADMIN_AUTHORITY;

	private static Logger logger = LoggerFactory.getLogger(LibraryProjectApplication.class);

	@Override
	public void run(String... args) throws Exception {

//		User user = User.builder()
//				.username("gfg_user")
//				.password(passwordEncoder.encode("gfg_pass1234"))
//				.authorities(ADMIN_AUTHORITY)
//				.build();
//
//		User user2 = User.builder()
//				.username("geeks_user")
//				.password(passwordEncoder.encode("geeks_pass1234"))
//				.authorities(ADMIN_AUTHORITY)
//				.build();
//
//		userRepository.saveAll(Arrays.asList(user, user2));
	}
}
