/*
 * 저작자 : 201413385 송현수
 * 저작일 : 2021/06/14
 * 내용 : 후위 표기식을 이용한 계산 프로그램.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
    private static final char PLUS_OPERATOR = '+';
    private static final char MINUS_OPERATOR = '-';
    private static final char MUL_OPERATOR = '*';
    private static final char DIV_OPERATOR = '/';
    private static final char OPEN_OPERATOR = '(';

    private Stack<Character> postfixStack;
    private Stack<Double> calculatorStack;
    private StringBuilder convertedExpression;
    private final Map<Character, Integer> operatorPriority = new HashMap<>();
    {
        operatorPriority.put(MUL_OPERATOR, 2);
        operatorPriority.put(DIV_OPERATOR, 2);
        operatorPriority.put(MINUS_OPERATOR, 1);
        operatorPriority.put(PLUS_OPERATOR, 1);
        operatorPriority.put(OPEN_OPERATOR, 0);
    }

    // 식을 후위표기식으로 바꾸는 메서드
    public String makeExpressionPostfix(String expression) {
        int expLength = expression.length();
        postfixStack = new Stack<>();
        convertedExpression = new StringBuilder();

        int i = 0;
        char eachChar;
        while (i < expLength) {
            eachChar = expression.charAt(i);

            // 해당하는 char가 숫자인지 검사.
            if (!validateNumber(eachChar)) {
                if (eachChar == '(') {
                    postfixStack.push(eachChar);
                }
                // char가 ) 이면 (가 나올 때 까지 pop한다.
                else if (eachChar == ')') {
                    while (postfixStack.peek() != '(') {
                        convertedExpression.append(postfixStack.pop());
                        convertedExpression.append(' ');
                    }
                    postfixStack.pop();
                } else {
                    // 연산자일 경우에 우선순위를 판단하기 위해 비교를 한다.
                    if (!postfixStack.isEmpty() &&
                            operatorPriority.get(postfixStack.peek()) >= operatorPriority.get(eachChar)) {
                        convertedExpression.append(postfixStack.pop());
                        convertedExpression.append(' ');
                    }
                    postfixStack.push(eachChar);
                }
                i++;
            } else {
                while (i < expLength && validateNumber(expression.charAt(i))) {
                    convertedExpression.append(expression.charAt(i));
                    i++;
                }
                // 1자리 이상의 숫자일 경우를 구분하기 위해서 공백을 삽입.
                convertedExpression.append(' ');
            }
        }

        while (!postfixStack.isEmpty()) {
            convertedExpression.append(postfixStack.pop());
            convertedExpression.append(" ");
        }

        return convertedExpression.toString();
    }

    //숫자인지 판단하는 메서드 0-9 사이면 true.
    public boolean validateNumber(char number) {
        return (number - '0' >= 0 && number - '0' <= 9);
    }

    // 식을 받아 계산하는 메서드
    public double calculateExpression(String expression) {
        calculatorStack = new Stack<>();

        //식을 먼저 후위 표기법으로 변환
        String postFixExpression = makeExpressionPostfix(expression);
        String[] splitPostFix = postFixExpression.split(" ");

        double firstNumber, secondNumber;
        for (String s : splitPostFix) {
            char sCharAt = s.charAt(0);
            // s가 4개의 연산자 중 하나인지 체크.
            if (sCharAt == MINUS_OPERATOR || sCharAt == PLUS_OPERATOR ||
                    sCharAt == MUL_OPERATOR || sCharAt == DIV_OPERATOR) {
                // 연산을 위해 숫자 2개를 pop
                secondNumber = calculatorStack.pop();
                firstNumber = calculatorStack.pop();

                double temp = 0;
                if (sCharAt == PLUS_OPERATOR) {
                    temp = firstNumber + secondNumber;
                } else if (sCharAt == MINUS_OPERATOR) {
                    temp = firstNumber - secondNumber;
                } else if (sCharAt == MUL_OPERATOR) {
                    temp = firstNumber * secondNumber;
                } else {
                    temp = firstNumber / secondNumber;
                }

                calculatorStack.push(temp);
            } else {
                calculatorStack.push(Double.valueOf(s));
            }
        }
        //마지막 stack에 남은 숫자가 결과값
        return calculatorStack.pop();
    }
}
