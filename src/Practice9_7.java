/*
 * 저작자 : 201413385 송현수
 * 저작일 : 2021/05/03
 * 내용 : 계산기 프로그램의 외형을 출력하는 프로그램
 */

import java.awt.*;
import javax.swing.*;

public class Practice9_7 extends JFrame {
    class NorthPanel extends JPanel {
        public NorthPanel() {
            setBackground(Color.LIGHT_GRAY);
            JLabel l1 = new JLabel("수십입력"); // 라벨 설정
            add(l1); // 라벨 삽입
            JTextField tf = new JTextField(10);
            add(tf);// 텍스트 필드 삽입
        }
    }



    class SouthPanel extends JPanel {
        public SouthPanel() {
            setBackground(Color.YELLOW);
            JLabel l2 = new JLabel("계산결과"); // 라벨 세팅
            JTextField tf = new JTextField(10);
            add(l2); // 라벨 삽입
            add(tf); // 텍스트 필드 삽입
        }
    }

    public Practice9_7() {
        setTitle("계산기 프레임");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane(); // 컨테이너 생성

        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new SouthPanel(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Practice9_7();
    }
}