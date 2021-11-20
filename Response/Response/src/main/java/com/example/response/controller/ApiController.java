package com.example.response.controller;


import com.example.response.controller.DTO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/text")
    public String text(String a){
        a = "카카";
        return a;
    }

    //요청 -> object Mapper을 거쳐서 -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/post")
    public User JSON(@RequestBody User user){

        return user;
    }

    //response status를 정해주기 위해 ResponseEntity라는 객체를 사용함
    @PutMapping("/put")
    public ResponseEntity<User> put (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
        //HttpStatus.Created - 201반환
    }
}
