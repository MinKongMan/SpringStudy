import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class) //목처리를 통해 가짜 클래스를 만들어 실험
public class CalculatorTest {

    @Mock // MarketApi를 모킹처리
    public MarketApi marketApi;

    @BeforeEach // 테스트가 실행되기 이전에
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
        //마켓 Api의 커넥트가 호출이 될 때 3000을 return하겠다.

    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);


        Assertions.assertEquals(22000,calculator.sum(10,10));
    }


    @Test
    public void mockTest(){
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        //목 처리된 marketApi를 가져와서 실험함
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);


        Assertions.assertEquals(60000,calculator.sum(10,10));
    }
}
