public class Calculator {
    public static double calculateSquareRoot(double x) {
        return Math.sqrt(x);
    }

    public static double calculateSquare(double x) {
        return x * x;
    }

    public static double calculateMultiply(double x, double y) {
        return Math.pow(x, y);
    }

    public static double calculateTenSquare(double x) {
        return Math.pow(10, x);
    }

    public static double calculateFactorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

//    public static double calculateTan(double x) {
//        return Math.tan;
//    }

    public static void main(String[] args) {
        System.out.println(calculateSquareRoot(25));
        System.out.println(calculateFactorial(10));
    }
}
