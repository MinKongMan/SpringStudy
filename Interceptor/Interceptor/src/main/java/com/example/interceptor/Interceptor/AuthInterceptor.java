package com.example.interceptor.Interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString()).build().toUri();//URI의 쿼리문을 가져 옴

        log.info("request url : {}",url);

        //권한체크 할 예정
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation ? : {}",hasAnnotation);

        //나의 서버는 모두 public으로 동작하는데
        // 단 Auth 즉 권한을 가진 요청에 대해서는 세션, 쿠키, RequestParameter의 특정값을 보든지 해서 통과시킨다.
        if(hasAnnotation){
            //권한 체크
            String query = uri.getQuery();
            log.info("query : {}",query);
            if(query.equals("name = steve")) return true;
            throw new AuthException();

        }

        return true; // true가 되어야 이것을 통과하고 안의 로직을 작동시킴(controller 패키지의 내부 클래스)
    }

    private boolean checkAnnotation(Object handler, Class clazz){
        // resource javascript, html 등 리소스에 대한 요청일 때는 통과시켜 줌
        if(handler instanceof ResourceHttpRequestHandler) return true;

        // annotation 체크
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(handlerMethod.getMethodAnnotation(clazz)!=null ||
        handlerMethod.getBeanType().getAnnotation(clazz) != null){
            //Auth annotation이 있을때는  true

            return true;
        }

        return false;
    }
}
