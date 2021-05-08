package com.example.gfg.libraryproject.books;

import com.example.gfg.libraryproject.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select b from Book b where b.name =:book_name")
    public List<Book> getBookByNameUsingJPQL(String book_name);


    @Query(value = "select * from book b where b.name = ?1", nativeQuery = true)
    public List<Book> getBookByNameUsingSQL(String book_name);

//    @Transactional
//    @Modifying
//    @Query("update Book b set b.my_student =")
//    public void updateBook(Book book);
}
