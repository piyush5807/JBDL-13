package com.example.jbdl13.demojpasecurity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String u);
}
