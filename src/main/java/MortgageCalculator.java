public abstract class MortgageCalculator {

    // Calculates the customer's monthly payment
    public static double monthlyPayment(MortgageData md) {
        double totalLoan = md.getTotalLoan();
        double m_interest = md.getMonthlyInterest();
        int payments = 12 * md.getYears();
        return totalLoan * m_interest * MortgageMath.pow(1 + m_interest, payments)
                / (MortgageMath.pow(1 + m_interest, payments) - 1);
    }


}
