package starbuzz.components;

public class HouseBlend extends SizedBeverage {

    public HouseBlend(BeverageSize size) {
        super(size);
    }

    @Override
    public String description() {
        return "House Blend";
    }

    @Override
    public double baseCost() {
        return 0.89;
    }
}
