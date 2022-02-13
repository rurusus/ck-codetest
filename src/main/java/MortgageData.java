
public class MortgageData {

    private String name;
    private double totalLoan;
    private double annualInterest;
    private int years;

    public MortgageData(String name, double totalLoan, double annualInterest, int years) {
        this.name = name;
        this.totalLoan = totalLoan;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getAnnualInterest() {
        return annualInterest;
    }

    public double getMonthlyInterest() {
        return annualInterest / 12;
    }

    public int getYears() {
        return years;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MortgageData)) {
            return false;
        }
        MortgageData md = (MortgageData) o;
        final double accuracy = 0.001;  // accuracy for comparing doubles
        return name.equals(md.getName()) &
                MortgageMath.abs(totalLoan - md.getTotalLoan()) <= accuracy &
                MortgageMath.abs(annualInterest - md.getAnnualInterest()) <= accuracy &
                years == md.getYears();
    }
}
