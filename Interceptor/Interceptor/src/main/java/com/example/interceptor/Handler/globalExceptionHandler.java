package com.example.interceptor.Handler;

import com.example.interceptor.Interceptor.AuthInterceptor;
import com.example.interceptor.exception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity authException(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        //동작 방식
        //인터셉터에서 권한이 없으면 throw시킴
        //핸들러(@RestControllerAdvice)로 받아서 AuthException이 터지면 UNAUTHORIZED(401)을 내리겠다고 설정
    }


}
