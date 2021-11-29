package com.example.filter.Filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@Component // 스프링에의해 빈으로 관리
/*
* @WebFilter(urlPattern = "/api/user/*") 이러면 원하는 부분의 하위 모든 주소에 매칭시켜 줌
*
* */
public class globalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //전처리 구간
        //내가 한번 찍어봐야겠다 할 때 ContentCachingRequestWrapper와 ContentCachingResponseWrapper사용
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse =
                new ContentCachingResponseWrapper ((HttpServletResponse) response);


        // 원래 HttpServletRequest 와 HttpServletResponse로 받아들였으나 이러면 다 읽힌 상태라 실제로 읽을 때 오류가 남
        // 그래서 ContentCachingRequestWrapper와 ContentCachingResponseWrapper를 사용해서 내용을
        // ByteArrayOutputStream에 저장하여 저장된 것을 리턴하여 읽도록 함




        chain.doFilter(httpServletRequest, httpServletResponse); // 실제로 처리하는 지점

        String url = httpServletRequest.getRequestURI();

//        BufferedReader br = httpServletRequest.getReader();
//        br.lines().forEach(line ->{
//            log.info("url : {}, line : {}",url, line);
//        });
        //후처리 구간

        String reqcontent = new String(httpServletRequest.getContentAsByteArray()); // 바디 내용 카피



        log.info("request url : {}, request body : {}", url, reqcontent);

        String resContent = new String(httpServletResponse.getContentAsByteArray()); // 응답 내용 카피
        int httpStatuscode = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse(); // response도 읽어서 return되지 않음. 그래서 복사를 해줌(무조건 해줘야 함)


        log.info("response status : {}, responseBody : {}", httpStatuscode, resContent);



    }
}
