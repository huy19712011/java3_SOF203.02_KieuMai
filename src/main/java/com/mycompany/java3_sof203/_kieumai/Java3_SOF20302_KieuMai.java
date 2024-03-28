package com.mycompany.java3_sof203._kieumai;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Java3_SOF20302_KieuMai extends JFrame{

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Demo");
        frame.setResizable(true);

        ImageIcon image = new ImageIcon("vit.gif");
        frame.setIconImage(image.getImage());

        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.getContentPane().setBackground(new Color(0xFFFFFF));
    }
}
