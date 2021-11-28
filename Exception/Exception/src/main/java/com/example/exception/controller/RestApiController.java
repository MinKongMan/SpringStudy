package com.example.exception.controller;


import com.example.exception.DTO.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/get")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){
        //required는 RequestParam이 없어도 동작은 하는데, null이 들어감
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int a = 10+age;

        return user;
    }

    @PostMapping("/post")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }

    //해당 클래스에 예외처리를 먼저 시키면 글로벌하게 예외처리를 작성한 코드는 동작하지 않는다.
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}
