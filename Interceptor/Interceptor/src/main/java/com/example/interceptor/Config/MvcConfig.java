package com.example.interceptor.Config;


import com.example.interceptor.Interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor // final로 선언된 객체들의 생성자에서 주입받을 수 있도록 해줌
public class MvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);

        //다른 방식
        //특정 URL에 대해서 혹은 특정 URL은 빼고싶다 할 때
//        registry.addInterceptor(authInterceptor).addPathPatterns("/api/public/*")
//        registry.addInterceptor(authInterceptor).excludePathPatterns("/api/public/*")
//      위와 같이 해당 경로에서만 검사를 하겠다 혹은 해당 경로는 배제하겠다고 지정하면 굳이 어노테이션을 타지 않더라도

        //인증도 순서대로 동작됨
    }
}
