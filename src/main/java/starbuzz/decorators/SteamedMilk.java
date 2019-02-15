package starbuzz.decorators;

import starbuzz.components.Beverage;

public class SteamedMilk extends Condiment {

    public SteamedMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + " + Steamed Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }
}
