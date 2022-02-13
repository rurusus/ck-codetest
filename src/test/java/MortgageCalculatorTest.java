import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgageCalculatorTest {

    @Test
    void monthlyPayment() {
        final double accuracy = 0.001;

        MortgageData md1 = new MortgageData("Foo", 10000, 10, 5);
        double result1 = MortgageCalculator.monthlyPayment(md1);
        assertTrue(MortgageMath.abs(result1 - 8333.333333) <= accuracy);

        MortgageData md2 = new MortgageData("Bar", 10000, 1.2, 1);
        double result2 = MortgageCalculator.monthlyPayment(md2);
        assertTrue(MortgageMath.abs(result2 - 1467.633151) <= accuracy);

    }
}