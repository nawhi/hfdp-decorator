package starbuzz.components;

import static starbuzz.components.BeverageSize.*;

public abstract class SizedBeverage extends Beverage {
    private BeverageSize size;

    SizedBeverage(BeverageSize size) {
        this.size = size;
    }

    abstract double baseCost();

    @Override
    public double cost() {
        double cost = baseCost();

        if (size == GRANDE)
            cost *= 1.25;

        if (size == VENTI)
            cost *= 1.5;

        return cost;
    }
}
