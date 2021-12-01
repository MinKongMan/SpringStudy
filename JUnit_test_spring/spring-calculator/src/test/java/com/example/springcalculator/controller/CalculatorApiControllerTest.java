package com.example.springcalculator.controller;


import com.example.springcalculator.DTO.Req;
import com.example.springcalculator.component.Calculator;
import com.example.springcalculator.component.DollarCalculator;
import com.example.springcalculator.component.MarketApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@WebMvcTest(CalculatorApiController.class) // SpringBootTest는 모든 것을 빈으로 등록하기 때문에 자원낭비가 심함 하지만 이 어노티에션은 필요한 것만 등록
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class}) // 위에서 불러온 클래스에서 Calculator가 주입을 받고 있어 Calculator클래스를 빈으로 등록해줘야 함
@RestController
@RequestMapping("/api")
public class CalculatorApiControllerTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach // 테스트 init때마다 초기화
    public void init(){
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }


    @Test
    public void sumTest() throws Exception {


        mockMvc.perform(
                MockMvcRequestBuilders.get("http:localhost:8080/api/sum")
                        .queryParam("x","10")
                        .queryParam("y","10")

        ).andExpect(
                MockMvcResultMatchers.status().isOk()// status가 ok를 기대해야 하고
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void minusTest() throws Exception {

        Req req = new Req();
        req.setX(10);
        req.setY(10);


        String json = new ObjectMapper().writeValueAsString(req); // 오브젝트를 Json으로 바꾸는 법
        mockMvc.perform(
                MockMvcRequestBuilders.post("http:localhost:8080/api/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("0") // 응답의 result기대
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.reultCode").value("OK")  // 응답의 바디 기대
        ).andDo(MockMvcResultHandlers.print());
    }
}
