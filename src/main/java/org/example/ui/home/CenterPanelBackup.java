package org.example.ui.home;

import javax.swing.*;
import java.awt.*;

public class CenterPanelBackup extends JPanel {
    public CenterPanelBackup() {
        // 수직 박스 레이아웃
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 배경 패널과 구글 이미지 패널 추가
        add(createBackgroundPanel(100));
        add(createGoogleImagePanel("src/main/java/org/example/ui/home/icon/googlebanner.jpg", 100));
        add(createBackgroundPanel(40));
    }

    private JPanel createBackgroundPanel(int height) {
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        backgroundPanel.setBackground(Color.YELLOW);
        backgroundPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        backgroundPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return backgroundPanel;
    }

    private JPanel createGoogleImagePanel(String imagePath, int height) {
        JPanel googleImagePanel = new JPanel();
        googleImagePanel.setLayout(new BoxLayout(googleImagePanel, BoxLayout.Y_AXIS));
        googleImagePanel.setBackground(Color.BLACK);
        googleImagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        googleImagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon banner = new ImageIcon(imagePath);
        JLabel bannerLabel = new JLabel(banner);
        bannerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        googleImagePanel.add(bannerLabel);

        return googleImagePanel;
    }
}
