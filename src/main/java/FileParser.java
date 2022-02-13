import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser implements Parser {

    // Parse mortgage data from file with path filePath and return it as a list of MortgageData objects.

    public List<MortgageData> parseFile(String filePath) {
        List<MortgageData> dataList = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                MortgageData data = parseLine(line);
                if (data != null) {
                    dataList.add(data);
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    // Parse mortgage data from a single line and return a single MortgageData object.

    public static MortgageData parseLine(String line) {
        boolean insideQuotes = false;
        int i = 0;
        char c = Character.MIN_VALUE;

        // Fetch name. Ignore quotation marks around the name, if there are any
        String name = "";
        while (i < line.length()) {
            c = line.charAt(i);
            if (c != ',' | insideQuotes) {
                if (c == '\"') {
                    insideQuotes = !insideQuotes;
                }
                if (c != '\"') {
                    name += c;
                }
                ++i;
            }
            else break;
        }
        ++i;

        // fetch total loan
        String totalLoanString = "";
        while (i < line.length()) {
            c = line.charAt(i);
            if (c != ',') {
                if (c != ' ') {
                    totalLoanString += c;
                }
                ++i;
            }
            else break;
        }
        ++i;
        double totalLoan = -1;
        try {
            totalLoan = Double.parseDouble(totalLoanString);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return null;
        }

        // get annual interest
        String interestString = "";
        while (i < line.length()) {
            c = line.charAt(i);
            if (c != ',') {
                if (c != ' ') {
                    interestString += c;
                }
                ++i;
            }
            else break;
        }
        ++i;
        double interest = -1;
        try {
            interest = Double.parseDouble(interestString);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return null;
        }

        // get years
        String yearsString = "";
        while (i < line.length()) {
            c = line.charAt(i);
            if (c != ',') {
                if (c != ' ') {
                    yearsString += c;
                }
                ++i;
            }
            else break;
        }
        int years = -1;
        try {
            years = Integer.parseInt(yearsString);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return null;
        }

        return new MortgageData(name, totalLoan, interest, years);
    }
}
