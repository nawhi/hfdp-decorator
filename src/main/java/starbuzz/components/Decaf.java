package starbuzz.components;

public class Decaf extends SizedBeverage {

    public Decaf(BeverageSize size) {
        super(size);
    }

    @Override
    double baseCost() {
        return 1.05;
    }

    @Override
    public String description() {
        return "Decaf";
    }
}
