package com.example.springcalculator.component;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator{

    private final Icalculator icalculator;

    public int sum(int x, int y){
        this.icalculator.init();
        return this.icalculator.sum(x,y);
    }

    public int min(int x, int y){
        this.icalculator.init();
        return this.icalculator.min(x,y);
    }

}
