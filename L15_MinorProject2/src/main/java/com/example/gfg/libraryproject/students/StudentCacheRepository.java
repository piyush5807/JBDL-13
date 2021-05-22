package com.example.gfg.libraryproject.students;

import com.example.gfg.libraryproject.RedisConfig;
import com.example.gfg.libraryproject.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentCacheRepository {

    private static final String STUDENT_PREFIX = "student::";
    private static final String STUDENT_LIST_KEY = "student_list";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private String getKeyForStudentByUserName(String username){
        return STUDENT_PREFIX + username;
    }

    public void saveStudentByUserName(Student student){

        if(student.getUser() == null){
            return;
        }

        String username = student.getUser().getUsername();

        // TODO: Add expiration in the set function
        redisTemplate.opsForValue().set(getKeyForStudentByUserName(username), student);

    }

    public Student findStudentByUser(User user){
        String username = user.getUsername();
        return (Student) redisTemplate.opsForValue().get(getKeyForStudentByUserName(username));
    }
}
