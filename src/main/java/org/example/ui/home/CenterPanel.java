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
        add(createShortcutBar()); // 바로가기 숏컷 추가
        add(createBackgroundPanel(180));

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
            }
        });

        add(createBottomBarPanel());  // 🔽 하단 바에 버튼 추가



    }

    //박스 컨테이너 가로 여백을 위한 박스 패널
    private JPanel createBackgroundPanel(int height) {
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS)); // 여백박스도 BoxLayout으로 설정하여 다른요소와 충돌 방지
        backgroundPanel.setBackground(Color.BLACK); // 박스 패널의 배경색은 BLACK으로 , TEST시에는 다른색으로 설정해서 디버깅
        backgroundPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height)); // 가로는 MAX값, Height만 인자로 빼와서 조정
        backgroundPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 박스 레이아웃은 수직배치를 위해서는 모든 요소를 CENTER_ALIGNMENT를 해줘야함
        return backgroundPanel; // Container의 파라미터가 JPANEL객체로 받기때문에 JPANEL으로 선언된 객체를 Return 해줘야함
    }

    //Google image를 배치하기 위한 패널 설정
    private JPanel createGoogleImagePanel(String imagePath, int height) {
        JPanel googleImagePanel = new JPanel();
        googleImagePanel.setLayout(new BoxLayout(googleImagePanel, BoxLayout.Y_AXIS)); //JPANEL을 BoxLayout으로 생성하여 수직배치 선언
        googleImagePanel.setBackground(Color.BLACK); // 이미지를 제외한 BACKGROUND의 COLOR를 BLACK으로 설정
        googleImagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height)); // 가로길이를 MAX로 설정하고 이미지 크기에 따라 height 조정 -> 추후 수정대비
        googleImagePanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 패널을 CENTER로 정렬

        // IMAGE를 중앙에 배치하기 위한 작업
        ImageIcon banner = new ImageIcon(imagePath); //imagePath에 GOOGLE 이미지를 설정하고 ImageIcon 객체를 생성
        JLabel bannerLabel = new JLabel(banner); // JLabel에 배너이미지를 담음 ( 가장 간편한 방법 )
        bannerLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //배너레이블을 센터로 정렬 ( 매우중요함. Center_alignment는 부모요소 기준으로 위치를 배치 )
        googleImagePanel.add(bannerLabel); //bannerlabel 객체를 googleimagepanel에 배치함

        return googleImagePanel;
    }

    //Searchbar를 작업하기 위한 패널 ( 가장 어려움 )
    private JPanel createSearchBarPanel() {
        RoundedPanel panel = new RoundedPanel(30); //패널을 Round로 만들기 위해 ROUNDPANEL 컴포넌트를 클래스로 따로 생성
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // 박스 레이아웃으로써 panel에 요소 배치시 박스레이아웃으로 배치
        panel.setMaximumSize(new Dimension(700, 40));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 아이콘 경로 수정 필요 + 아이콘배치는 JLabel객체에 담아 배치하는것이 가장 간편함
        JLabel searchIcon = new JLabel(new ImageIcon("src/main/java/org/example/ui/home/icon/search.png"));
        JLabel micIcon = new JLabel(new ImageIcon("src/main/java/org/example/ui/home/icon/mic.png"));
        JLabel lensIcon = new JLabel(new ImageIcon("src/main/java/org/example/ui/home/icon/lens.png"));

        // 텍스트 필드 + placeholder
        JTextField textField = new JTextField();
        String placeholder = "Google 검색 또는 URL 입력";
        textField.setForeground(Color.GRAY); // textfield의 폰트를 회색으로 설정
        textField.setText(placeholder); // placeholder의 텍스트 설정
        textField.setBorder(null);
        textField.setBackground(Color.WHITE);

        // TextField가 Focus를얻었을때와 잃었을때의 동작을 설정해줌
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                } // textField에 포커스가 생겼을때는 텍스트를 비우고 입력을 받게됨
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                } // textField의 값이 비었을때는 textField의 값을 placeholder로 설정
            }
        });

        // 여백 조절
        panel.add(Box.createRigidArea(new Dimension(10, 0))); // 패널에 추가한 요소들의 가로 여백 설정
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

    // 둥근 모서리 패널 ( 컴포넌트 커스텀은 설명 X )
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

    //숏컷바 요소설정 및 박스 레이아웃 배치
    private JPanel createShortcutBar() {
        JPanel shortcutPanel = new JPanel();
        shortcutPanel.setLayout(new BoxLayout(shortcutPanel, BoxLayout.X_AXIS)); // 숏컷 요소를 박스레이아웃으로 X정렬
        shortcutPanel.setOpaque(false); // 배경을 투명하게 설정 -> 색을 줄땐 true로 해야함
        shortcutPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 패널자체를 센터배치를 통해 다른 요소와 충돌 방지

        shortcutPanel.add(Box.createHorizontalGlue());

        String[] labels = {
                "ado", "mrsgreenapple", "officailhigedandism", "tuyu", "vaundyu", "yoasobi", "yorushika"
        }; //추후 다중 숏컷 구현을 위한 배열 선언


        String[] iconPaths = {
                "src/main/java/org/example/ui/home/icon/ado.jpg",
                "src/main/java/org/example/ui/home/icon/mrsgreenapple.jpg",
                "src/main/java/org/example/ui/home/icon/officailhigedandism.jpg",
                "src/main/java/org/example/ui/home/icon/tuyu.jpg",
                "src/main/java/org/example/ui/home/icon/vaundyu.jpg",
                "src/main/java/org/example/ui/home/icon/yoasobi.jpg",
                "src/main/java/org/example/ui/home/icon/yorushika.jpg"
        }; // 아이콘들의 path 설정

        for (int i = 0; i < labels.length; i++) {
            shortcutPanel.add(createShortcutItem(iconPaths[i], labels[i]));
            if (i != labels.length - 1) {
                shortcutPanel.add(Box.createRigidArea(new Dimension(20, 0)));
            }
        } // 아이콘의 갯수만큼 숏컷패널에 숏컷 아이템 요소 추가

        shortcutPanel.add(Box.createHorizontalGlue());

        return shortcutPanel;
    }

    //숏컷 아이템을 만들기 위한 전처리 과정
    private JPanel createShortcutItem(String iconPath, String labelText) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setOpaque(false);
        itemPanel.setPreferredSize(new Dimension(90, 110));
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 원형 이미지 아이콘 생성
        JLabel iconLabel = new JLabel(getRoundedImageIcon(iconPath, 72));
        iconLabel.setPreferredSize(new Dimension(72, 72));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //숏컷 하단 레이블 설정
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

    //이미지 아이콘을 원형으로 만들기 위한 전처리 과정 ( 커스텀은 설명 X )
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

    //우측 하단 아이콘을 배치하기 위한 버튼 설정파트
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

    // 하단 패널을 담을 패널 생성 -> Flowlayout으로 South 배치로도 가능
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
