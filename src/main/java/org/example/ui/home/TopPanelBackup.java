package org.example.ui.home;

import javax.swing.*;
import java.awt.*;

public class TopPanelBackup extends JPanel {
    public TopPanelBackup() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(0, 40)); // 전체 패널 높이


        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
        totalPanel.setPreferredSize(new Dimension(280, 40)); // 너비/높이 임시 설정
        totalPanel.setBackground(Color.DARK_GRAY);
        totalPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2)); // 눈에 보이게
        totalPanel.setLayout(new BoxLayout(totalPanel,BoxLayout.X_AXIS));

        JPanel labelBox = new JPanel();
        labelBox.setLayout(new BoxLayout(labelBox, BoxLayout.X_AXIS));
        labelBox.setOpaque(false);
        labelBox.setPreferredSize(new Dimension(140, 40));
        labelBox.setMaximumSize(new Dimension(140,40));
        labelBox.setMinimumSize(new Dimension(140,40));
        labelBox.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // 눈에 보이게

        JPanel iconBox = new JPanel();
        iconBox.setLayout(new BoxLayout(iconBox, BoxLayout.X_AXIS));
        iconBox.setOpaque(false);
        iconBox.setPreferredSize(new Dimension(140, 40));
        iconBox.setMaximumSize(new Dimension(140,40));
        iconBox.setMinimumSize(new Dimension(140,40));
        iconBox.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // 눈에 보이게

        totalPanel.add(labelBox);
        totalPanel.add(iconBox);
        add(totalPanel, BorderLayout.EAST);


    }
}

