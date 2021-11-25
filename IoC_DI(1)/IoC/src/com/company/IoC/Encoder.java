package com.company.IoC;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoder {

    private IEncoder iEncoder;
    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;

        //Encoder입장에서는 외부에서 주입을 받음(Dependecy Injection)
        //즉 의존을 가지고 있는 애를 주입 받음 
    }
    public String encode(String message){

        return iEncoder.encode(message);
    }
}
