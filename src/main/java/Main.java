import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter filepath: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        MortgageApplication app = new MortgageApplication();
        app.run(path);
    }
}
