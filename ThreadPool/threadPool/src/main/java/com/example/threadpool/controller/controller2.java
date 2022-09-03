package com.example.threadpool.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class controller2 {
    private Logger log = LoggerFactory.getLogger(controller2.class);
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<Void> shoot5(){
        RestTemplate restTemplate = new RestTemplate();
        for(int i = 1; i<=5; i++){
            Thread thread = new Thread(() ->{
               log.info("발사");
               String result = restTemplate.getForObject("http://localhost:8080/hello",String.class);
               log.info(result);
            });
            thread.start();
        }
        return ResponseEntity.ok().build();
    }
}
