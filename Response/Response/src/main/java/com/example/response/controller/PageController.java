package com.example.response.controller;


import com.example.response.controller.DTO.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){

        return "main.html"; //html파일 찾아감
    }

    //이 부분에서 JSON은 어떻게 내려줄 것인가??

    //ResponseEntity

    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();
        // var - 타입 추론 (긴 클래스 명일 때 var로 생략할 수 있다)
        user.setName("Kang");
        user.setAddress("DONGGUK");
        return user;
    }

}
