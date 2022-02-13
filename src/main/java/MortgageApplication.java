import java.util.List;

public class MortgageApplication {
    public String run(String path) {
        String result = "";
        Parser parser = new FileParser();
        List<MortgageData> dataList = parser.parseFile(path);
        for (int i = 0; i < dataList.size(); i++) {
            MortgageData md = dataList.get(i);
            String name = md.getName();
            double totalLoan = md.getTotalLoan();
            int years = md.getYears();
            double monthlyPayment = MortgageCalculator.monthlyPayment(md);

            String outputTemplate =
                "****************************************************************************************************\n" +
                "Prospect %d: %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month\n" +
                "****************************************************************************************************";
            String output = String.format(outputTemplate, i+1, name, totalLoan, years, monthlyPayment);
            result += output + "\n";
        }
        System.out.println(result);
        return result;
    }
}
