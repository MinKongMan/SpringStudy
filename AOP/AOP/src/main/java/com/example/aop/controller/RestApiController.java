package com.example.aop.controller;

import com.example.aop.DTO.User;
import com.example.aop.annotation.Decode;
import com.example.aop.annotation.timer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        return id+" "+name;
    }


    @PostMapping("/post")
    public User post(@RequestBody User user){
        return user;
    }

    @timer //내가 만든 거
    @DeleteMapping("/delete") // 2초 있다가 종료
    public void delete() throws InterruptedException {

        // db logic


        Thread.sleep(1000*2);
    }


    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put : "+user);



        return user;


    }
}
