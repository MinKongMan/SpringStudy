package com.example.springcalculator.component;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({MarketApi.class, DollarCalculator.class}) // 이 클래스는 marketApi를 주입받고 있기 때문에 Import해준다.
public class DollarCalculatorTest {

    @MockBean
    private MarketApi marketApi;


    @Autowired
    private DollarCalculator dollarCalculator;

    @Test
    public void dollarCalculatorTest(){

        Mockito.when(marketApi.connect()).thenReturn(3000);
        //마켓Api의 커넥트가 일어날 때 3000을 return 시킨다.
        dollarCalculator.init(); // 여기서 마켓Api의 커넥트가 일어남
        int sum = dollarCalculator.sum(10,10);

        Assertions.assertEquals(60000,sum);

    }


}
