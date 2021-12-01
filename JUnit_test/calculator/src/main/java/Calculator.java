public class Calculator{

    private Icalculator icalculator;

    public Calculator(Icalculator icalculator){
        this.icalculator = icalculator;
    }

    public int sum(int x, int y){
        return this.icalculator.sum(x,y);
    }

    public int min(int x, int y){
        return this.icalculator.min(x,y);
    }

}
