package com.example.gfg.libraryproject.students;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.books.BookRequest;
import com.example.gfg.libraryproject.books.BookService;
import com.example.gfg.libraryproject.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/list")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public void createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        studentService.createStudent(createStudentRequest);
    }

    @PutMapping("/student")
    public void updateEmail(@RequestParam("name") String name, @RequestParam("email") String email){

        studentService.updateStudent(email, name);
    }

    @GetMapping("/student/details")
    public Student getStudentDetails(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principalObject = (User) authentication.getPrincipal();

        return studentService.getStudentByUser(principalObject);
    }

}
