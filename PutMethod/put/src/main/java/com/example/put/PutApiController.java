package com.example.put;


import com.example.put.DTO.RequestUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{kang}")
    public RequestUser put(@RequestBody RequestUser RU, @PathVariable(name = "kang") Long min ){
        System.out.println(RU.toString()+" "+min);
        return RU;
        //오브젝트를 리턴해도 알아서 JSON으로 바꿔준다.
    }
}
