package com.company.IoC;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Encode implements IEncoder{

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
