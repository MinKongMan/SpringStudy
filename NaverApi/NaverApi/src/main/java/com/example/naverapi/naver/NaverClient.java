package com.example.naverapi.naver;

import com.example.naverapi.naver.dto.SearchImageReq;
import com.example.naverapi.naver.dto.SearchImageRes;
import com.example.naverapi.naver.dto.SearchLocalReq;
import com.example.naverapi.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.websocket.Extension;


@Component
public class NaverClient {

    @Value("${naver.client.id}") // yaml파일의 naver -> client -> id를 의미
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    @Value("${naver.url.search.local}")
    private String localUrl;

    @Value("${naver.url.search.image}")
    private String Img;


    public SearchLocalRes localSearch(SearchLocalReq req){
        var uri = UriComponentsBuilder.fromUriString(localUrl)
                .queryParams(req.toMultiValueMap()) //쿼리를 SearchLocalReq에서 미리 만들어 줌
                .build()
                .encode()
                .toUri();

        var header = new HttpHeaders();
        header.set("X-Naver-Client-Id",clientId);
        header.set("X-Naver-Client-Secret",clientSecret);
        header.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(header); // 헤더 담음

        var resType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var ResponseEntity = new RestTemplate().exchange(
                uri, HttpMethod.GET, httpEntity, resType
        );

        return ResponseEntity.getBody();
    }

    public SearchImageRes imageSearch(SearchImageReq req){
        var uri = UriComponentsBuilder.fromUriString(Img)
                .queryParams(req.toMultiValueMap()) //쿼리를 SearchLocalReq에서 미리 만들어 줌
                .build()
                .encode()
                .toUri();

        var header = new HttpHeaders();
        header.set("X-Naver-Client-Id",clientId);
        header.set("X-Naver-Client-Secret",clientSecret);
        header.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(header); // 헤더 담음

        var resType = new ParameterizedTypeReference<SearchImageRes>(){};

        var ResponseEntity = new RestTemplate().exchange(
                uri, HttpMethod.GET, httpEntity, resType
        );

        return ResponseEntity.getBody();

    }
}
