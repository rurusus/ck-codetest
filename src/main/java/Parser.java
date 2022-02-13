import java.util.List;

public interface Parser {
    List<MortgageData> parseFile(String filepath);
}
