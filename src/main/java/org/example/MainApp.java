package org.example;

import javax.swing.*;
import java.awt.*;
import org.example.framework.BaseFrame;
import org.example.ui.home.CenterPanel;
import org.example.ui.home.TopPanel;

public class MainApp
{
    MainApp(){
        BaseFrame frame = new BaseFrame();
        frame.add(new TopPanel(),BorderLayout.NORTH);
        frame.add(new CenterPanel(),BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void main( String[] args )
    {
        new MainApp();
    }
}
