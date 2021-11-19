package com.example.hello.controller;

import com.example.hello.DTO.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http:localhost:9090/api/get/hello
    public String hello(){
        return "get hello";
    }

    //@RequestMapping("/hi") 이렇게 하면 get / post / put / delete 모두 동작
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // 그래서 get만 지정하고
    //싶을 때 path = 경로, method = RequestMethod.GET 해줘야 함
    public String hi(){
        return "hi";
    }

    //http:localhost:9090/api/get/path-variable/{name} name이 바뀔 때 마다 함수를 만들 수
    //없으니 {name}으로 정해주고 변화하는 부분은 @PathVariable를 통해 받아준다.
    // 중괄호에 들어있는 이름과 매개변수의 변수가 같아야 한다
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("Pathvariable : "+name);
        return name;
    }

    //개발을 할 때 이름이 중복될 수 있음.
    //그럴 때 @PathVariable의 name에 {}안의 이름 똑같이 적용
    @GetMapping("/path-variable2/{name}")
    public String pathVariable2(@PathVariable(name = "name") String pathName, String name){
        System.out.println("Pathvariable : "+name);
        name = "ㅋㅋ";
        return pathName+" "+name;
    }

    //쿼리 파라미터 : 검색을 할 때 여러가지 매개변수 인자
    //search?
    // q = pathvariable+%EC%97%AC%EB%9F%AC%EA%B0%9C
    // &oq = Pathvariable+
    // &aqs = chrome.2.69i57j0i512l3j0i20i263i512j0i512l5.4736j0j7
    // &sourceid = chrome
    // &ie = UTF-8

    // ?key = value & key2 = value2

    //http:localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @RequestMapping(path = "query-param",method = RequestMethod.GET)
//    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> qp){
        StringBuilder sb = new StringBuilder();
        qp.entrySet().forEach( entry -> {
            System.out.println(entry.getKey()+" "+entry.getValue());
            System.out.println();
            sb.append(entry.getKey()+" "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    //query param에 넣을 수 있는건 email과 이름과 나이만 넣어야 할 때

    @GetMapping(path = "query-param2")
    public String qP(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }

    //DTO 만들어서 언제든지 받아야할 매개변수가 변할 때

    //매개변수로 객체가 들어올 때
    //?user=steve&email=steve@gmail.com&age=30 ?뒤에 키를 알아서 판단해 준다.
    @GetMapping(path = "query-param3")
    public String QP(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
