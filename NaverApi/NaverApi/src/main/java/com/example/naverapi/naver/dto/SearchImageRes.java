package com.example.naverapi.naver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageRes { // 출력 결과 중 몇개 변수만 가져 올 예정

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<SearchImageItem> items;
    //Api 문서에 item에 포함되는 항목들을 만들어 준다

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchImageItem{
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }
}
