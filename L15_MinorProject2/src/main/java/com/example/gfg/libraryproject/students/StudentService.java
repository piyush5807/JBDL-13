package com.example.gfg.libraryproject.students;

import com.example.gfg.libraryproject.books.Book;
import com.example.gfg.libraryproject.books.BookRepository;
import com.example.gfg.libraryproject.user.User;
import com.example.gfg.libraryproject.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // select * from student where email = 'abc@google.com'

    @Autowired
    StudentRepository studentRepository;

    @Value("${my_app.student.authority}")
    private String STUDENT_AUTHORITY;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserService userService;

    @Autowired
    StudentCacheRepository studentCacheRepository;

    public void createStudent(CreateStudentRequest createStudentRequest) {
        // create a user
        User user = User.builder()
                .username(createStudentRequest.getUsername())
                .authorities(STUDENT_AUTHORITY)
                .password(encoder.encode(createStudentRequest.getPassword()))
                .build();

        userService.createUser(user);

        Student student = Student.builder()
                .age(createStudentRequest.getAge())
                .name(createStudentRequest.getName())
                .email(createStudentRequest.getEmail())
                .user(user)
                .build();

        studentRepository.save(student);
        studentCacheRepository.saveStudentByUserName(student);
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

    public Student getStudentByUser(User user){

        Student student = studentCacheRepository.findStudentByUser(user);
        if(student == null){
            student = studentRepository.findByUser(user);
            studentCacheRepository.saveStudentByUserName(student);
        }

        return student;
    }
}
