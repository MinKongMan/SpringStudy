package com.example.naverapi.place.Entity;


import com.example.naverapi.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class placeEntity extends MemoryDbEntity {
    private String title;               //장소명
    private String category;            //카테고리
    private String address;             //주소
    private String readAddress;         //도로명
    private String hompageLink;         //홈페이지
    private String imageLink;           //이미지
    private boolean isVisit;            //방문 여부
    private int visitCount;             //방문 횟수
    private LocalDateTime lastVisitDate;//마지막 방문 일자

}
