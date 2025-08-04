package org.example.framework;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {

    public BaseFrame() {
        setTitle("Google Clone Practice");
        setSize(1280, 720);  // 16:9 비율
        setResizable(false); // 🔒 창 크기 조절 불가능하게!
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙 정렬
        setLayout(new BorderLayout());

        setLocation(-1600, 100);  // 예시: 왼쪽 모니터로 위치 이동
        getContentPane().setBackground(Color.BLACK); // 배경 색 기본값
        setVisible(true);
    }
}

