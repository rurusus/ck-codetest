import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgageApplicationTest {

    @Test
    void run() {

        // Test running the program on the prospects.txt

        String result = "";
        String outputTemplate =
            "****************************************************************************************************\n" +
            "Prospect %d: %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month\n" +
            "****************************************************************************************************";
        MortgageData md1 = new MortgageData("Juha", 1000, 5, 2);
        MortgageData md2 = new MortgageData("Karvinen", 4356, 1.27, 6);
        MortgageData md3 = new MortgageData("Claes Månsson", 1300.55, 8.67, 2);
        MortgageData md4 = new MortgageData("Clarencé,Andersson", 2000, 6, 4);
        result += String.format(outputTemplate, 1, md1.getName(), md1.getTotalLoan(), md1.getYears(), MortgageCalculator.monthlyPayment(md1)) + "\n";
        result += String.format(outputTemplate, 2, md2.getName(), md2.getTotalLoan(), md2.getYears(), MortgageCalculator.monthlyPayment(md2)) + "\n";
        result += String.format(outputTemplate, 3, md3.getName(), md3.getTotalLoan(), md3.getYears(), MortgageCalculator.monthlyPayment(md3)) + "\n";
        result += String.format(outputTemplate, 4, md4.getName(), md4.getTotalLoan(), md4.getYears(), MortgageCalculator.monthlyPayment(md4)) + "\n";
        MortgageApplication app = new MortgageApplication();
        String appOutput = app.run("src/test/resources/prospects.txt");
        assertEquals(result, appOutput);
    }
}