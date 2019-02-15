package starbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import starbuzz.components.*;
import starbuzz.decorators.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static starbuzz.components.BeverageSize.*;

class BeveragesTest {

    @Test
    void decaf_with_steamed_milk_and_whip_should_cost_1_25() {
        Beverage beverage = new Whip(new SteamedMilk(new Decaf(TALL)));
        assertEquals(1.25, beverage.cost(), 0.01);
    }

    @Test
    void espresso_with_mocha_should_cost_2_29() {
        Beverage beverage = new Mocha(new Espresso(TALL));
        assertEquals(2.19, beverage.cost(), 0.01);
    }

    @ParameterizedTest
    @MethodSource("coffeeCosts")
    void coffees_are_billed_correctly(Class<Beverage> component, List<Class<Condiment>> decorators, double expectedCost) throws Exception {
        Beverage beverage = createBeverage(component, decorators);
        assertEquals(expectedCost, beverage.cost(), 0.01);
    }

    private static Stream<Arguments> coffeeCosts() {
        return Stream.of(
                Arguments.of(Espresso.class, asList(Mocha.class), 2.19),
                Arguments.of(Decaf.class, asList(Whip.class, SteamedMilk.class), 1.25),
                Arguments.of(HouseBlend.class, asList(SteamedMilk.class, Mocha.class, Soy.class, Whip.class), 1.44)
        );
    }

    @ParameterizedTest
    @MethodSource("coffeeDescriptions")
    void coffees_are_described_correctly(Class<Beverage> component, List<Class<Condiment>> decorators, String expectedDescription) throws Exception {
        Beverage beverage = createBeverage(component, decorators);

        assertEquals(expectedDescription, beverage.description());
    }

    private static Stream<Arguments> coffeeDescriptions() {
        return Stream.of(
                Arguments.of(Espresso.class, asList(Mocha.class), "Espresso + Mocha"),
                Arguments.of(DarkRoast.class, asList(Mocha.class, SteamedMilk.class, Whip.class, Soy.class), "Dark Roast + Mocha + Steamed Milk + Whip + Soy")
        );
    }

    private Beverage createBeverage(Class<Beverage> component, List<Class<Condiment>> decorators) throws Exception {
        Beverage beverage = component.getConstructor(BeverageSize.class).newInstance(TALL);
        for (var decorator : decorators) {
            beverage = decorator.getConstructor(Beverage.class).newInstance(beverage);
        }
        return beverage;
    }
}