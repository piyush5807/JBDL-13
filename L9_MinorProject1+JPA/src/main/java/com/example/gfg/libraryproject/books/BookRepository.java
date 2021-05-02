package com.example.gfg.libraryproject.books;

import com.example.gfg.libraryproject.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select b from Book b where b.name =:book_name")
    public List<Book> getBookByNameUsingJPQL(String book_name);


    @Query(value = "select * from book b where b.name = ?1", nativeQuery = true)
    public List<Book> getBookByNameUsingSQL(String book_name);
}
