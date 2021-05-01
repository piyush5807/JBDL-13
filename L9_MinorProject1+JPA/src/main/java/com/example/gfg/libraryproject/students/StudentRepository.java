package com.example.gfg.libraryproject.students;

import com.example.gfg.libraryproject.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
