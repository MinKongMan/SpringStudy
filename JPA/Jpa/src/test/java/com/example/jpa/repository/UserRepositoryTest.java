package com.example.jpa.repository;

import com.example.jpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void save(){
        userRepository.save(new User());
        userRepository.findAll().forEach(System.out::println);
    }
    
    @Test
    void update(){
        User user = new User();
        user.setName("ㅎㅇ");
        userRepository.save(user);
        userRepository.save(new User());
        System.out.println(userRepository.findAll());
    }
}