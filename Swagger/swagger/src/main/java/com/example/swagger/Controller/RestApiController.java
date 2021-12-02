package com.example.swagger.Controller;


import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(tags={"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get")
    public String Hello(){

        return "Hello";
    }

    @GetMapping("/plus/{x}")
    public int sum(
            @ApiParam(value = "x값")
            @PathVariable int x,
            @ApiParam(value = "y값")
            @RequestParam int y){

        return x+y;
    }

    @GetMapping("/user")
    public UserRes uesr(UserReq userReq){

        return new UserRes(userReq.getAge(), userReq.getName());
    }


}
