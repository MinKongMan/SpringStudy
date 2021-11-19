package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 class는 REST API 처리하는 controller
@RequestMapping("/api") // RequestMapping URI를 지정해주는 어노테이션
public class APIController {

    @GetMapping("/hello") // Get방식으로 http://localhost:9090/api/hello에 매핑
    public String Hello(){
        return "Hello spring boot";
    }

}
