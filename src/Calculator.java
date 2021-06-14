public class Calculator {
    private final String[] operator = new String[]{"+", "-", }
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

    // 숫자들을 입력받아 평균을 구하는 메서드
    public static double getMean(String numbers) {
        String[] splitNumbers = numbers.split(" ");
        double result = 0;

        for (String splitNumber : splitNumbers) {
            result += Double.parseDouble(splitNumber);
        }

        return result/ splitNumbers.length;
    }

    // 숫자들을 입력받아 분산을 구하는 메서드
    public static double getVariance(String numbers) {
        double result = 0;
        double mean = getMean(numbers);

        String[] splitNumbers = numbers.split(" ");
        for (String splitNumber : splitNumbers) {
            double temp = Double.parseDouble(splitNumber);
            result += Math.pow(temp - mean, 2);
        }

        return result / splitNumbers.length;
    }

    // 숫자들을 입력받아 표준편차를 구하는 메서드
    public static double getStd(String numbers) {
        return Math.sqrt(getVariance(numbers));
    }

    public static double calculateExpression(String expression) {

    }

    public static void main(String[] args) {
        System.out.println(calculateSquareRoot(25));
        System.out.println(calculateFactorial(10));
    }
}
