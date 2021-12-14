package com.example.jpa.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setName("KMK");
        user.setEmail("dmk@naver.com");
        System.out.println(user.toString());
    }
}