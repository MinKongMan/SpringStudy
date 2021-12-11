package com.example.naverapi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class pageController {

    @GetMapping("/main")
    public ModelAndView main(){
        return new ModelAndView("Main/main"); // 템플릿 하위의 경로
    }
}
