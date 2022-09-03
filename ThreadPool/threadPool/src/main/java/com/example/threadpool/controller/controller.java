package com.example.threadpool.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
@Controller
public class controller {
    private Logger log =  LoggerFactory.getLogger(controller.class);
    @RequestMapping("/hello")
    public ResponseEntity<Void> shoot() throws InterruptedException{
        log.info("start");
        Thread.sleep(3000);
        log.info("end");
        return ResponseEntity.ok().build();
    }
}
