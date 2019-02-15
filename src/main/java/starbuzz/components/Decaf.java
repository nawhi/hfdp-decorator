package starbuzz.components;

public class Decaf extends Beverage {

    @Override
    public String description() {
        return "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
