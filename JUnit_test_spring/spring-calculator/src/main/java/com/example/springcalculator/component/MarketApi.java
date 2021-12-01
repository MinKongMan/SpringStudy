package com.example.springcalculator.component;


import org.springframework.stereotype.Component;

@Component // DollarCalculator가 컴포넌트로 등록되어서 생성자로 주입 받는 얘도 컴포넌트로 등록되어야 함.
public class MarketApi {

    public int connect(){
        return 1100;
    }
}
