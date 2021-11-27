package com.example.validation.controller;

import com.example.validation.DTO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class apicontroller {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult ){
        //필요한 객체에 대해 검증이 필요할 때 @Valid를 붙여줘야 함
        //그럼 해당 클래스 안의 Valid와 관련된 어노테이션을 검사
        System.out.println(user);

        //BindingResult - 에러가 났을 때 BindingResult에 값이 들어 옴.
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println(field.getField()+" / "+message);
                //에러 메시지가 이쁘지 않음 그래서 여기서(phone) 해당 변수로 가서 예쁘게 변경할 수 있음

                sb.append("field : "+field.getField()+"\n");
                sb.append("message : "+message +"\n");
            });
            System.out.println(user);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        return ResponseEntity.ok(user);
    }
}
