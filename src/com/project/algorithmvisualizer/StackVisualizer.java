package com.project.algorithmvisualizer;

import javax.swing.*;
import java.awt.*;

import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class StackVisualizer extends JPanel {

    public StackVisualizer(){
        setBackground(Color.gray);
    }

    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        g.setColor(Color.white);
        g.drawString("TESTING",100,200);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }
}
