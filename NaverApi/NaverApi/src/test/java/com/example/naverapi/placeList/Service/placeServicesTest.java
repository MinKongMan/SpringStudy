package com.example.naverapi.placeList.Service;


import com.example.naverapi.place.Service.PlaceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class placeServicesTest {
    @Autowired
    private PlaceService pS;

    @Test
    public void testSearch(){
        var result = pS.search("경복궁");

        System.out.println(result);

        Assertions.assertNotNull(result);


    }

}
