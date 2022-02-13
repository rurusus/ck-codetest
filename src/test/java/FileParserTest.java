import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

    @org.junit.jupiter.api.Test
    void parseFile() {
        // Test parseFileTest.txt
        /*
        * John,1.0, 2.0,6
        * Boris, 4.0, 4.0, 4
        * "Bar,Foo", 5000, 3.0, 10
        *
        */
        MortgageData md1 = new MortgageData("John", 1.0, 2.0, 6);
        MortgageData md2 = new MortgageData("Boris", 4.0, 4.0, 4);
        MortgageData md3 = new MortgageData("Bar,Foo", 5000, 3.0, 10);

        FileParser parser = new FileParser();
        List<MortgageData> mdlist = parser.parseFile("src/test/resources/parseFileTest.txt");
        assertEquals(md1, mdlist.get(0));
        assertEquals(md2, mdlist.get(1));
        assertEquals(md3, mdlist.get(2));
    }

    @org.junit.jupiter.api.Test
    void parseLine1() {

        // Tests the follow line
        // Foo Bar,1.0,2.0,5

        FileParser parser = new FileParser();
        String testLine = String.format("%s,%f,%f,%d", "Foo Bar", 1.0, 2.0, 5);
        MortgageData md = parser.parseLine(testLine);
        assertTrue(md.getName().equals("Foo Bar"));
        assertTrue(md.getTotalLoan() == 1.0);
        assertTrue(md.getAnnualInterest() == 2.0);
        assertTrue(md.getYears() == 5);
    }

    @org.junit.jupiter.api.Test
    void parseLine2() {

        // Tests the follow line
        // "Foo, Bar", 100, 2.0,5

        FileParser parser = new FileParser();
        String testLine = String.format("%s, %d, %f,%d ", "\"Foo, Bar\"", 100, 2.0, 5);
        MortgageData md = parser.parseLine(testLine);
        assertTrue(md.getName().equals("Foo, Bar"));
        assertTrue(md.getTotalLoan() == 100);
        assertTrue(md.getAnnualInterest() == 2.0);
        assertTrue(md.getYears() == 5);
    }
}