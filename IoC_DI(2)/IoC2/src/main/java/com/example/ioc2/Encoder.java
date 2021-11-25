package com.example.ioc2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Component // Base64Encode도 컴포넌트, UrlEncode도 컴포넌트임.
// 컴포넌트가 1개일 땐 자동으로 맞춰주지만 2개 이상이면 오류가 생김
// 그래서 길을 지정해 줘야 함
public class Encoder {

    private IEncoder iEncoder;
    public Encoder(@Qualifier("base74Encode") IEncoder iEncoder){//@Qulifier로 길을 지정해줌
        this.iEncoder = iEncoder;

        //Encoder입장에서는 외부에서 주입을 받음(Dependecy Injection)
        //즉 의존을 가지고 있는 애를 주입 받음
    }

    public void setiEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){

        return iEncoder.encode(message);
    }
}
