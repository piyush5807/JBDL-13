package com.example.gfg.libraryproject.students;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // select * from student where email = 'abc@google.com'

    @Autowired
    StudentRepository studentRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void updateStudent(String email, String name){
        studentRepository.updateEmailFunction(email, name);
    }

    public Student getStudentById(int studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
}
