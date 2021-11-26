package com.example.aop.AOP;

import com.example.aop.annotation.timer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAOP {

    @Pointcut("execution(* com.example.aop..*.*(..)))")
    private void cut(){}

    @Before("cut()")//메소드 이름을 넣음
    public void before(JoinPoint joinPoint){ // JoinPoint : 들어가는 지점
        Object[] args = joinPoint.getArgs();


        //어떤 메소드가 실행됐는지 메소드 이름 출력
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());


        for(Object kang : args){
            System.out.println("type : "+kang.getClass().getSimpleName());
            System.out.println("value : "+kang);
        }
    }

    @AfterReturning(value = "cut()", returning = "object") // returning이름 매칭 시켜 줘야함
    public void after(JoinPoint joinPoint, Object object){
        System.out.println("return obj : "+object);
    }

    //execution에서 하위에 있는 메소드가 실행되기 전에 before가 실행됨.
    //메서드가 실행 되고 리턴이 될 때 after의 object값을 볼 수 있다



}
