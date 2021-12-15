package com.example.jpa.domain;

import lombok.*;

import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
