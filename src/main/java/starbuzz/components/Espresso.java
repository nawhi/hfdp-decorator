package starbuzz.components;

public class Espresso extends SizedBeverage {
    public Espresso(BeverageSize size) {
        super(size);
    }

    @Override
    public String description() {
        return "Espresso";
    }

    @Override
    public double baseCost() {
        return 1.99;
    }
}
