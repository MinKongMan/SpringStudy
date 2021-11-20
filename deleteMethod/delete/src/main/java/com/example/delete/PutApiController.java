package com.example.delete;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PutApiController {
    @DeleteMapping("/del/{account}")
    public void del(@PathVariable String account, @RequestParam String id){
        System.out.println(account+" "+id);
    }

}
