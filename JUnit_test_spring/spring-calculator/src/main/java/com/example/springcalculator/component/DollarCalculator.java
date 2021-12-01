package com.example.springcalculator.component;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements Icalculator {

    private int price = 1;
    private final MarketApi marketApi;

    @Override
    public void init(){
        this.price = marketApi.connect();
    }


    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x+y;
    }

    @Override
    public int min(int x, int y) {
        x *= price;
        y *= price;
        return x-y;
    }
}
