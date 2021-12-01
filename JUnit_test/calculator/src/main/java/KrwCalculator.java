public class KrwCalculator implements  Icalculator{

    private int price = 1;

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
