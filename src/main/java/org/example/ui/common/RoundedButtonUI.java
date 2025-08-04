package org.example.ui.common;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class RoundedButtonUI extends BasicButtonUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 배경 색
        if (b.getModel().isRollover()) {
            g2.setColor(new Color(230, 230, 230));
        } else {
            g2.setColor(Color.WHITE);
        }

        // 둥근 배경
        g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 40, 40);

        g2.dispose();
        super.paint(g, c);
    }
}
