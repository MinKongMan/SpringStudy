package com.example.jpa.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
@Entity
public class User {
    @Id
    @GeneratedValue // 자동으로 증가
    private Long Id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


}
