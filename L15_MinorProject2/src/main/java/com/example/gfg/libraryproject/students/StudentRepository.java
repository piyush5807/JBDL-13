package com.example.gfg.libraryproject.students;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select b from Student b where b.email = :student_email")
    public Student getStudentForEmailByJPQL(String student_email);


    @Query(value = "select b from student b where b.email = :email", nativeQuery = true)
    public Student getStudentForEmailBySQL(String email);

    // 1. Native SQL query - Book
    // 2. JPQL query - Java persistence query language


    @Modifying
    @Query("update Student s SET s.email = :email where s.name =:name")
    public void updateEmailFunction(String email, String name);

    // update student set email = 'nathan@gmail.com' where name = 'Nathan';


    public Student findByUser(User user);
}
