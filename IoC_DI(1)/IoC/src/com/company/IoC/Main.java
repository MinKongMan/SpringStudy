package com.company.IoC;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base 64로 인코딩 하세요.

        Base64Encode base64Encode = new Base64Encode();
        String result = base64Encode.encode(url);
        System.out.println(result);

        //url 인코딩을 해야하는 조건이 나옴
        UrlEncoder urlEncoder = new UrlEncoder();
        String urlresult = urlEncoder.encode(url);
        System.out.println(urlresult);


        //추상을 적용 시켜 봄

        IEncoder base64Encode1 = new Base64Encode();
        String result1 = base64Encode.encode(url);
        System.out.println(result1);

        IEncoder urlEncoder1= new UrlEncoder();
        String urlresult1 = urlEncoder.encode(url);
        System.out.println(urlresult1);

        //추상화를 시켰지만 여전히 변한 것이 없음.
        //그래서 DI를 넣어서 조금 변경 시키도록 할 예정
        //Encoder 클래스 내부의 생성자를 매번 바꿔줘야 할 필요 없이 주입 객체만 바꾸면 됨
        Encoder encoder = new Encoder(new UrlEncoder());
//        Encoder encoder = new Encoder(new Base64Encode());
        String encoder_result = encoder.encode(url);
        System.out.println(encoder_result+" 최종본 ");
	// write your code here
    }
}
