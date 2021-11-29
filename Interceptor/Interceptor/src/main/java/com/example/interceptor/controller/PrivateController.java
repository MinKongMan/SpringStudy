package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Auth // 인터셉터에서 다음 메소드 또는 컨트롤러에 Auth 어노테이션이 붙어 있으면 세션을 검사해서 있을 때만 통과
public class PrivateController {
    @GetMapping("hello")
    public String Hello(){
        return "Hello";
    }

}
