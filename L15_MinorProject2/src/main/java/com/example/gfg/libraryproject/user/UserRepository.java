package com.example.gfg.libraryproject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("select U from User U where U.username = ?1")
    public User findByUsername(String username);
}
