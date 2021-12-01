package com.example.springcalculator.controller;


import com.example.springcalculator.DTO.Req;
import com.example.springcalculator.DTO.Res;
import com.example.springcalculator.component.Calculator;
import com.example.springcalculator.component.Icalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;
    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y){

        return calculator.sum(x,y);

    }

    @PostMapping("/post")
    public Res minus(@RequestBody Req req){
        int result = calculator.min(req.getX(),req.getY());

        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());

        return res;
    }
}
