package com.example.aop.AOP;

import com.example.aop.annotation.timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;

@Aspect
@Component
public class TimerAOP {
    @Pointcut("execution(* com.example.aop..*.*(..)))")
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.timer)")
    private void enableTimer(){}

    //Before와 After는 타임을 공유할 수 없다. 그래서 다른 것을 써줌
    @Around("cut() && enableTimer()")
    public void arround(/*Around의 파라미터*/ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        Object result = joinPoint.proceed(); // 메서드가 여기서 실행됨
        stopWatch.stop();

        System.out.println("total sec : "+stopWatch.getTotalTimeSeconds());
    }
}
