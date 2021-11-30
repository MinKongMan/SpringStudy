package com.example.server.controller;


import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
//            HttpEntity<String> entity, //이걸 넣어주면 순수하게 뭘 보냈는지 알 수 있음
            @RequestBody Req<User> user,
            @PathVariable String userId,
            @PathVariable int userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customHeader
                     ){
//        log.info("req : {}", entity.getBody());
        log.info("client req : {}",user);
        log.info("authorization : {}",authorization);
        log.info("custom-header : {}",customHeader);
        log.info("user Id : {}, userName : {}",userId, userName);

        Req<User> response = new Req<>();
        response.setHeader( new Req.Header());
        response.setBody(user.getBody());
        return response;
    }
}
