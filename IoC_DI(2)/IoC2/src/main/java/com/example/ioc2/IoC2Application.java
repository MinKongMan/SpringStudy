package com.example.ioc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@SpringBootApplication
public class IoC2Application {

    public static void main(String[] args) {

        SpringApplication.run(IoC2Application.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        Base64Encode base64Encode = context.getBean(Base64Encode.class);
        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = new Encoder(base64Encode);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);
        System.out.println(result);
        encoder.setiEncoder(urlEncoder);
        String result2 = encoder.encode(url);



        System.out.println("------------------");
        System.out.println(result2);


        // Encoder도 @Component붙인 뒤

        Encoder encoder1 = context.getBean(Encoder.class);
        String result3 = encoder1.encode(url);
        System.out.println(result3);
    }

}


//빈으로 직접 등록하는 방법
@Configuration // 한 개의 클래스에서 여러개의 빈을 등록할 것이다.
class Appconfig{

    @Bean("base64Encode")
    public Encoder encoder(Base64Encode base64Encode){
        return new Encoder(base64Encode);
    }

    @Bean("UrlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }

    //Encoder라는 빈이 2개가 생기는 문제가 발생-> 이름 붙이면 됨
}