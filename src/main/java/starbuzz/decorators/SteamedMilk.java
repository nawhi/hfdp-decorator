package starbuzz.decorators;

import starbuzz.components.Beverage;

public class SteamedMilk extends Condiment {

    public SteamedMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String name() {
        return "Steamed Milk";
    }

    @Override
    public double extraCost() {
        return .10;
    }
}
