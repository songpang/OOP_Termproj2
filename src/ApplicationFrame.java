/*
 * 저작자 : 201413385 송현수
 * 저작일 : 2021/06/14
 * 내용 : 후위 표기식을 이용한 계산 프로그램.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationFrame extends JFrame {
    private final JTextArea mainTextField = new JTextArea();
    private final Calculator calculator = new Calculator();
    private final JTextField resultTextField = new JTextField("Solution  ");
    private boolean isMode = true;

    public ApplicationFrame() {
        // 오른쪽, 왼쪽패널 생성
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JButton modeBtn = new JButton("Mode");

        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2));
        container.setBackground(Color.GRAY);

        panelLeft.setLayout(new GridLayout(3, 1, 5, 10));

        resultTextField.setEditable(false);
        resultTextField.setBackground(Color.white);
        resultTextField.setHorizontalAlignment(SwingConstants.SOUTH_EAST);
        resultTextField.setFont(new Font("Arial", Font.BOLD, 20));

        panelLeft.add(resultTextField);
        panelLeft.add(new CenterPanel());
        panelLeft.add(new BottomPanel());

        container.add(panelLeft);

        panelRight.setLayout(null);

        JLabel calculatorModeLabel = new JLabel("계산기 모드");
        calculatorModeLabel.setFont(new Font("돋움체", Font.BOLD, 15));
        calculatorModeLabel.setBounds(100, 8, 100, 20);
        panelRight.add(calculatorModeLabel);

        mainTextField.setBounds(7, 30, 280, 250);
        mainTextField.setFont(new Font("Arial", Font.BOLD, 16));
        mainTextField.setEditable(false);
        mainTextField.setBackground(Color.white);
        panelRight.add(mainTextField);

        modeBtn.setBounds(7, 300, 280, 50);
        // 계산기 모드, 통계 모드 전환을 위한 익명 클래스 선언.
        modeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculatorModeLabel.getText().equals("계산기 모드")) {
                    isMode = false;
                    calculatorModeLabel.setText("통계 모드");
                } else {
                    isMode = true;
                    calculatorModeLabel.setText("계산기 모드");
                }
            }
        });
        panelRight.add(modeBtn);
        container.add(panelRight);

        setSize(600, 400);
        setVisible(true);
    }

    class CenterPanel extends JPanel {
        public CenterPanel() {
            String[] str = {"√", "^2", "10^x", "x!", "1/x",
                    "ln", "log", "tan", "cos", "sin",
                    "std", "var", "mean"}; // 숫자 외 값들 설정
            setLayout(new GridLayout(4, 4, 3, 3));

            for (String s : str) {
                JButton b = new JButton();
                b.addActionListener(new CalActionListener());
                add(b);
                b.setText(s);
            }
        }
    }

    class BottomPanel extends JPanel {
        public BottomPanel() {
            String[] str = {"CE", "/", "*", "-",
                    "7", "8", "9", "+",
                    "4", "5", "6", "-",
                    "1", "2", "3", "=",
                    "0", ".", "(", ")"}; // 가장 아래 키패드 설정.
            setLayout(new GridLayout(5, 4, 3, 3));

            for (String s : str) {
                JButton b = new JButton();
                b.addActionListener(new CalActionListener());
                add(b);
                b.setText(s);
            }
        }
    }

    class CalActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // operation에 발생된 버튼을 입력.
            String operation = e.getActionCommand();
            // 계산기 모드일 경우
            if (isMode) {
                String expression = mainTextField.getText();
                switch (operation) {
                    case "=" -> {
                        double result = calculator.calculateExpression(expression);
                        resultTextField.setText(String.valueOf(result));
                    }
                    case "CE" -> {
                        mainTextField.setText("");
                        resultTextField.setText("Solution  ");
                    }
                    case "√" -> {
                        double temp = Double.parseDouble(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateSquareRoot(temp)));
                    }
                    case "^2" -> {
                        double temp = Double.parseDouble(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateSquare(temp)));
                    }
                    case "10^x" -> {
                        double temp = Double.parseDouble(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculate10Square(temp)));
                    }
                    case "1/x" -> {
                        double temp = Double.parseDouble(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateDivideBy(temp)));
                    }
                    case "x!" -> {
                        int temp = Integer.parseInt(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateFactorial(temp)));
                    }
                    case "ln" -> {
                        double temp = Integer.parseInt(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateLog(temp)));
                    }
                    case "log" -> {
                        double temp = Integer.parseInt(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateLog10(temp)));
                    }
                    case "cos" -> {
                        double temp = Integer.parseInt(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateCos(temp)));
                    }
                    case "sin" -> {
                        double temp = Integer.parseInt(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateSin(temp)));
                    }
                    case "tan" -> {
                        double temp = Integer.parseInt(expression);
                        resultTextField.setText(String.valueOf(AdditionalFunction.calculateTan(temp)));
                    }
                    default -> mainTextField.setText(mainTextField.getText() + e.getActionCommand());
                }
            } // 통계 모드일 경우
            else {
                String expression = mainTextField.getText();
                switch (operation) {
                    case "=" -> {
                        mainTextField.setText(expression + "\n");
                    }
                    case "CE" -> mainTextField.setText("");
                    case "std" -> { // 표준 편차
                        double result = AdditionalFunction.getStd(expression);
                        resultTextField.setText(String.valueOf(result));
                    }
                    case "var" -> { // 분산
                        double result = AdditionalFunction.getVariance(expression);
                        resultTextField.setText(String.valueOf(result));
                    }
                    case "mean" -> { // 평균
                        double result = AdditionalFunction.getMean(expression);
                        resultTextField.setText(String.valueOf(result));
                    }
                    default -> mainTextField.setText(mainTextField.getText() + e.getActionCommand());
                }
            }
        }
    }

    public static void main(String[] args) {
        new ApplicationFrame();
    }
}

