package com.example.naverapi.naver;

import com.example.naverapi.naver.dto.SearchImageReq;
import com.example.naverapi.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class naverClientTest {
    @Autowired
    private NaverClient naverClient;


    @Test
    public void SearchLocalTest(){
        var search = new SearchLocalReq();
        search.setQuery("경복궁");

        var k = naverClient.localSearch(search);

        System.out.println(k);

    }

    @Test
    public void SearchImageTest(){
        var search = new SearchImageReq();
        search.setQuery("경복궁");

        var k = naverClient.imageSearch(search);
        System.out.println(k);
    }

}
