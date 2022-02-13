public abstract class MortgageMath {

    // A very simple version of Math's pow function
    public static double pow(double b, int e) {
        double result = 1;
        for (int i = e; i > 0; i--) {
            result *= b;
        }
        return result;
    }

    // A very simple version of Math's abs function
    public static double abs(double d) {
        return (d >= 0)? d : -d;
    }
}
