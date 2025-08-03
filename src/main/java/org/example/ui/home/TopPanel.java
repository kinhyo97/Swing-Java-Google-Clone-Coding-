package org.example.ui.home;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class TopPanel extends JPanel {
    public TopPanel() {
        //TopPanel의 메인 레이아웃 컨셉 지정
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(0, 50)); // 전체 패널 높이

        //North에 있는 Top panel의 사이즈밑 위치 설정
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
        totalPanel.setPreferredSize(new Dimension(350, 40)); // 너비/높이 임시 설정
        totalPanel.setBackground(Color.BLACK);
        //totalPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2)); // 눈에 보이게
        totalPanel.setLayout(new BoxLayout(totalPanel,BoxLayout.X_AXIS));

        //Label을 넣을 박스와 Icon을 넣을 큰 박스 구성
        JPanel labelBox = createBox(Color.WHITE, 140, 40);
        JPanel iconBox = createBox(Color.WHITE, 180, 40);

        //레이블 설정
        JLabel label1 = new JLabel("Gmail");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
        JLabel label2 = new JLabel("이미지");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("맑은 고딕", Font.BOLD, 11));

        //레이블의 여백 설정
        label1.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0));
        label2.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0));

        //레이블패널 생성
        JPanel label1Panel = createLabelInnerPanel(Color.GREEN, 50, 40);
        JPanel label2Panel = createLabelInnerPanel(Color.GREEN, 50, 40);
        labelBox.add(label1Panel);
        labelBox.add(Box.createHorizontalStrut(10));
        labelBox.add(label2Panel);

        //레이블패널에 label을 담음
        label1Panel.add(label1);
        label2Panel.add(label2);

        //아이콘패널 생성
        JPanel icon1Panel = createLabelInnerPanel(Color.GREEN, 50, 40);
        JPanel icon2Panel = createLabelInnerPanel(Color.GREEN, 50, 40);
        JPanel icon3Panel = createLabelInnerPanel(Color.GREEN, 50, 40);


        // 아이콘 리스케일링
        ImageIcon rawIcon = new ImageIcon("src/main/java/org/example/ui/home/icon/searchLabicon.jpg");
        Image scaledImage = rawIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        ImageIcon rawIcon2 = new ImageIcon("src/main/java/org/example/ui/home/icon/googleAppicon.jpg");
        Image scaledImage2 = rawIcon2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(scaledImage2);

        ImageIcon rawIcon3 = new ImageIcon("src/main/java/org/example/ui/home/icon/profile.jpg");
        Image scaledImage3 = rawIcon3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon3 = new ImageIcon(scaledImage3);

        // 버튼생성 + 버튼이미지 아이콘으로 변경
        JButton iconButton = new JButton(resizedIcon);
        iconButton.setPreferredSize(new Dimension(30, 30));
        iconButton.setContentAreaFilled(false);
        iconButton.setFocusPainted(false);
        iconButton.setBorderPainted(false);
        //iconButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JButton iconButton2 = new JButton(resizedIcon2);
        iconButton2.setPreferredSize(new Dimension(30, 30));
        iconButton2.setContentAreaFilled(false);
        iconButton2.setFocusPainted(false);
        iconButton2.setBorderPainted(false);
        //iconButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JButton iconButton3 = new JButton(resizedIcon3);
        iconButton3.setPreferredSize(new Dimension(30, 30));
        iconButton3.setContentAreaFilled(false);
        iconButton3.setFocusPainted(false);
        iconButton3.setBorderPainted(false);
        //iconButton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));


        //아이콘패널에 아이콘버튼을 담음
        icon1Panel.add(iconButton);
        icon2Panel.add(iconButton2);
        icon3Panel.add(iconButton3);

        iconBox.add(icon1Panel);
        iconBox.add(Box.createHorizontalStrut(10));
        iconBox.add(icon2Panel);
        iconBox.add(Box.createHorizontalStrut(10));
        iconBox.add(icon3Panel);

        totalPanel.add(labelBox);
        totalPanel.add(Box.createHorizontalStrut(0));
        totalPanel.add(iconBox);
        add(totalPanel, BorderLayout.EAST);
    }

    private JPanel createBox(Color borderColor, int width, int height) {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.X_AXIS));
        box.setOpaque(false);
        Dimension size = new Dimension(width, height);
        box.setPreferredSize(size);
        box.setMaximumSize(size);
        box.setMinimumSize(size);
        //box.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        return box;
    }

    private JPanel createLabelInnerPanel(Color borderColor, int width, int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        //panel.setBorder(BorderFactory.createLineBorder(borderColor, 2));

        Dimension size = new Dimension(width, height);
        panel.setPreferredSize(size);
        panel.setMaximumSize(size);
        panel.setMinimumSize(size);

        return panel;
    }

}

