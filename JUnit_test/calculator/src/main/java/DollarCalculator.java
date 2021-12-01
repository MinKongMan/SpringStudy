public class DollarCalculator implements Icalculator{

    private int price = 1;
    private MarketApi marketApi;

    public DollarCalculator(MarketApi marketApi){
        this.marketApi = marketApi;
    }

    public void init(){
        this.price = marketApi.connect();
    }


    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x+y;
    }

    @Override
    public int min(int x, int y) {
        x *= price;
        y *= price;
        return x-y;
    }
}
