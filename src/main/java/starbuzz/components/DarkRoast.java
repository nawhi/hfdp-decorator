package starbuzz.components;

public class DarkRoast extends SizedBeverage {
    public DarkRoast(BeverageSize size) {
        super(size);
    }

    @Override
    public String description() {
        return "Dark Roast";
    }

    @Override
    public double baseCost() {
        return 0.99;
    }
}
