import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    class CenterPanel extends JPanel {
        public CenterPanel() {
            setLayout(new GridLayout(4, 4, 3, 3));
            String[] str = {"√ ", "x²", "x^y", "x!", "%", "ln", "log", "tan",
            "cos", "sin"}; // 숫자 외 값들 설정

            for (int i = 0; i < 10; i++) {
                JButton b = new JButton();
                add(b);
                b.setText(str[i]);
            }
        }
    }

    class BottomPanel extends JPanel {
        public BottomPanel() {
            setLayout(new GridLayout(4, 4, 3, 3));
            String[] str = {"CE", "Enter", "+", "-", "x", "/"}; // 숫자 외 값들 설정

            for (int i = 0; i < 16; i++) {
                JButton b = new JButton();
                add(b);
                if (i < 10) { // 1-9까지는 숫자 삽입
                    b.setText(String.valueOf(i));
                } else { // 그 이상부터는 위의 배정한 배열대로 삽입
                    b.setText(str[i - 10]);
                }
                if (i > 11) { // 11이 넘으면 다른 색으로 삽입
                     b.setOpaque(true);
                    setVisible(true);
                }
            }
        }
    }

    public ApplicationFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2));
        container.setBackground(Color.GRAY);

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(3, 1));

        panelLeft.add(new TextField());
        panelLeft.add(new CenterPanel());
        panelLeft.add(new BottomPanel());

        container.add(panelLeft);

        container.add(new JButton("Calculate"));

        setSize(600, 400);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ApplicationFrame();
    }
}

