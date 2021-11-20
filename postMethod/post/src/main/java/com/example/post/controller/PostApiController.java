package com.example.post.controller;

import com.example.post.DTO.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {
//    @PostMapping("/post")
//    public void post(@RequestBody Map<String,Object> requestData){
//        //get일 때는 @RequestParam
//        //post일 때는 @RequestBody http post 요청을 보낼 때 body에 데이터를 심었다는 의미
//        requestData.forEach((key, value) -> System.out.println(key + " " + value));
//    }

    @PostMapping("post")
    public void min(@RequestBody Request request){
        System.out.println(request.toString());
    }
}
