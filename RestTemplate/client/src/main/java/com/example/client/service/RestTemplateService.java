package com.example.client.service;

import com.example.client.DTO.Req;
import com.example.client.DTO.UserRequest;
import com.example.client.DTO.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {
    //http://localhost/api/server/hello 호출 후 응답을 받아 볼 것
    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                //쿼리를 넣고 싶을 땐
                .queryParam("name","aaaa")
                .queryParam("age",100)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);
        //get이 가져오겠다는게 아니라 위 uri의 http메서드 get을 의미. 오브젝트 형태로 가져올 것
        //String으로 데이터를 받음

        ResponseEntity<String> result2 = restTemplate.getForEntity(uri, String.class);
        //getForEntity를 하면 ResponseEntity로 받고 데이터 타입 지정

        System.out.println(result2.getStatusCode());
        System.out.println(result2.getBody());

        //그럼 제이슨 형태는 어떻게 받을 것인가??
        //받는 쪽에서 response에 대한 정의를 할 것이기 때문에 DTO클래스를 만들어 줌
        ResponseEntity<UserResponse> result3 = restTemplate.getForEntity(uri, UserResponse.class);
        //제네릭에 DTO 클래스를 넣고 오른쪽에 클래스도 변경시켜 줌

        return result3.getBody();
    }

    public UserResponse post(){
        //http://localhost:9090/api/server/user/{userId}/name/{userName}
        //유저 등록시키는 거 만들 예정

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", 500)//순서대로 매칭
                .toUri();

        //http body -> object -> objectMapper -> json -> restTemplate -> http body json
        //오브젝트만 보낼거라 오브젝트맵퍼가 제이슨으로 바꿔서 restTemplate에서 http body에 json으로 넣어 줄 것임

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> responseResponseEntity = restTemplate.postForEntity(uri, req, UserResponse.class);
        //uri에 어떤 데이터를 보낼꺼고, ~타입으로 받을거다. <- 순서대로

        System.out.println(responseResponseEntity.getStatusCode());
        System.out.println(responseResponseEntity.getHeaders());
        System.out.println(responseResponseEntity.getBody());

        return responseResponseEntity.getBody();


        //post 방식
        //주소 만들고 -> request바디 만들어주고 -> 응답을 어떻게 받을지 지정
    }

    public UserResponse exchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", 500)//순서대로 매칭
                .toUri();

        //http body -> object -> objectMapper -> json -> restTemplate -> http body json
        //오브젝트만 보낼거라 오브젝트맵퍼가 제이슨으로 바꿔서 restTemplate에서 http body에 json으로 넣어 줄 것임

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);


        //Request데이터 만들 거임
        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header","ffffff")
                .body(req);
        //requestEntity에 주소, 헤더내용, 바디들어감


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
        //원하는 헤더를 실어서 보내고 응답을 받음
        //exchange로 호출을 하면 우리가 원하는 값을 넣을 수 있다.
        return response.getBody();
    }

    public Req<UserResponse> genericExchange(){


        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", 500)//순서대로 매칭
                .toUri();

        //http body -> object -> objectMapper -> json -> restTemplate -> http body json
        //오브젝트만 보낼거라 오브젝트맵퍼가 제이슨으로 바꿔서 restTemplate에서 http body에 json으로 넣어 줄 것임


        UserRequest userRequest = new UserRequest();
        userRequest.setName("steve");
        userRequest.setAge(10);

        Req req = new Req<UserRequest>();
        req.setHeader(
            new Req.Header()
        );

        req.setBody(
            userRequest

        );


        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header","ffffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Req<UserResponse>> reqResponseEntity = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Req<UserResponse>>(){}); //제네릭을 넣은걸로는 클래스로 안 만들어짐
        return reqResponseEntity.getBody();
        //responseEntity의 바디를 가져와서 거기에서 내용을 꺼내기 위해 getBody를 함(req안에 있는 함수)
    }
}
