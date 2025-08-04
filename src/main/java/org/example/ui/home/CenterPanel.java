package org.example.ui.home;

import org.example.ui.common.RoundedButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CenterPanel extends JPanel {
    public CenterPanel() {
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(createBackgroundPanel(100)); // 여백 넣는코드
        add(createGoogleImagePanel("src/main/java/org/example/ui/home/icon/googlebanner.jpg", 100)); // 배너삽입 코드
        add(createBackgroundPanel(40));
        add(createSearchBarPanel()); // 검색창 추가
        add(createBackgroundPanel(20));
        add(createShortcutBar());
        add(createBackgroundPanel(180));

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
            }
        });

        add(createBottomBarPanel());  // 🔽 하단 바에 버튼 추가



    }

    private JPanel createBackgroundPanel(int height) {
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        backgroundPanel.setBackground(Color.BLACK);
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

    private JPanel createSearchBarPanel() {
        RoundedPanel panel = new RoundedPanel(30);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setMaximumSize(new Dimension(700, 40));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 아이콘 경로 수정 필요
        JLabel searchIcon = new JLabel(new ImageIcon("src/main/java/org/example/ui/home/icon/search.png"));
        JLabel micIcon = new JLabel(new ImageIcon("src/main/java/org/example/ui/home/icon/mic.png"));
        JLabel lensIcon = new JLabel(new ImageIcon("src/main/java/org/example/ui/home/icon/lens.png"));

        // 텍스트 필드 + placeholder
        JTextField textField = new JTextField();
        String placeholder = "Google 검색 또는 URL 입력";
        textField.setForeground(Color.GRAY);
        textField.setText(placeholder);
        textField.setBorder(null);
        textField.setBackground(Color.WHITE);

        // placeholder 동작
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });

        // 여백 조절
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(searchIcon);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(micIcon);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(lensIcon);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        return panel;
    }

    // 둥근 모서리 패널
    private static class RoundedPanel extends JPanel {
        private final int cornerRadius;

        public RoundedPanel(int radius) {
            super();
            this.cornerRadius = radius;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 배경 채우기
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcs.width, arcs.height);

            // 🔽 테두리 그리기 추가
            g2.setColor(Color.LIGHT_GRAY);  // 테두리 색 (선택 가능)
            g2.setStroke(new BasicStroke(1));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcs.width, arcs.height);
        }
    }

    private JPanel createShortcutBar() {
        JPanel shortcutPanel = new JPanel();
        shortcutPanel.setLayout(new BoxLayout(shortcutPanel, BoxLayout.X_AXIS));
        shortcutPanel.setOpaque(false);
        shortcutPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        shortcutPanel.add(Box.createHorizontalGlue());

        String[] labels = {
                "ado", "mrsgreenapple", "officailhigedandism", "tuyu", "vaundyu", "yoasobi", "yorushika"
        };

        String[] iconPaths = {
                "src/main/java/org/example/ui/home/icon/ado.jpg",
                "src/main/java/org/example/ui/home/icon/mrsgreenapple.jpg",
                "src/main/java/org/example/ui/home/icon/officailhigedandism.jpg",
                "src/main/java/org/example/ui/home/icon/tuyu.jpg",
                "src/main/java/org/example/ui/home/icon/vaundyu.jpg",
                "src/main/java/org/example/ui/home/icon/yoasobi.jpg",
                "src/main/java/org/example/ui/home/icon/yorushika.jpg"
        };

        for (int i = 0; i < labels.length; i++) {
            shortcutPanel.add(createShortcutItem(iconPaths[i], labels[i]));
            if (i != labels.length - 1) {
                shortcutPanel.add(Box.createRigidArea(new Dimension(20, 0)));
            }
        }

        shortcutPanel.add(Box.createHorizontalGlue());

        return shortcutPanel;
    }

    private JPanel createShortcutItem(String iconPath, String labelText) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setOpaque(false);
        itemPanel.setPreferredSize(new Dimension(90, 110));
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 🔴 원형 이미지 아이콘 생성
        JLabel iconLabel = new JLabel(getRoundedImageIcon(iconPath, 72));
        iconLabel.setPreferredSize(new Dimension(72, 72));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLabel = new JLabel(labelText);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);

        itemPanel.add(iconLabel);
        itemPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        itemPanel.add(textLabel);

        return itemPanel;
    }

    private ImageIcon getRoundedImageIcon(String imagePath, int size) {
        try {
            BufferedImage original = ImageIO.read(new File(imagePath));
            Image scaledImage = original.getScaledInstance(size, size, Image.SCALE_SMOOTH);

            BufferedImage rounded = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = rounded.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, size, size));
            g2.drawImage(scaledImage, 0, 0, null);
            g2.dispose();

            return new ImageIcon(rounded);
        } catch (IOException e) {
            e.printStackTrace();
            return new ImageIcon(); // 실패 시 빈 아이콘
        }
    }

    private JButton createBottomRightFloatingButton() {
        JButton button = new JButton("Chrome 맞춤설정");
        button.setIcon(new ImageIcon("src/main/java/org/example/ui/home/icon/edit.png")); // 연필 아이콘
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLUE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setIconTextGap(8);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);

        // 크기 및 둥근 모양
        button.setPreferredSize(new Dimension(180, 40));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // 둥글게 만들기
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setUI(new RoundedButtonUI());

        return button;
    }

    private JPanel createBottomBarPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setBackground(Color.BLACK); // 확인용 배경
        bottomPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        bottomPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        bottomPanel.add(Box.createHorizontalGlue());

        JButton settingButton = createBottomRightFloatingButton();
        bottomPanel.add(settingButton);

        bottomPanel.add(Box.createRigidArea(new Dimension(20, 0))); // 오른쪽 여백

        return bottomPanel;
    }






}
