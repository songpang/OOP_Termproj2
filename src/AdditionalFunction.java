public class AdditionalFunction {
    // 루트를 구하는 함수
    public static double calculateSquareRoot(double x) {
        return Math.sqrt(x);
    }

    //제곱을 구하는 함수
    public static double calculateSquare(double x) {
        return x * x;
    }

    //자연로그를 구하는 함수
    public static double calculateLog(double x) {
        return Math.log(x);
    }

    //밑이 10인 로그를 구하는 함수
    public static double calculateLog10(double x) {
        return Math.log10(x);
    }

    //10의 x승을 구하는 함수
    public static double calculate10Square(double x) {
        return Math.pow(10, x);
    }

    //Factorial을 구하는 함수
    public static double calculateFactorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    // 탄젠트 함수
    public static double calculateTan(double x) {
        return Math.tan(Math.toRadians(x));
    }

    // 사인 함수
    public static double calculateSin(double x) {
        return Math.sin(Math.toRadians(x));
    }

    // 코사인 함수
    public static double calculateCos(double x) {
        return Math.cos(Math.toRadians(x));
    }

    // x로 나눈 값을 구하는 함수
    public static double calculateDivideBy(double x) {
        return 1 / x;
    }

    // 숫자들을 입력받아 평균을 구하는 메서드
    public static double getMean(String numbers) {
        String[] splitNumbers = numbers.split("\n");
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

        String[] splitNumbers = numbers.split("\n");
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
}
