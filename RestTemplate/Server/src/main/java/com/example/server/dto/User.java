package com.example.server.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어 줌
public class User {

    private String name;
    private int age;
}
