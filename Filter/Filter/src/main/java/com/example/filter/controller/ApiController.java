package com.example.filter.controller;

import com.example.filter.DTO.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // log사용
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/post")
    public User user (@RequestBody User user){
        log.info("User : {}"+user.toString(), user);// 중괄호 안에 자동으로 맵핑됨


        return user;
    }

}
