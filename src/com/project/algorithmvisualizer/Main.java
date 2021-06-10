package com.project.algorithmvisualizer;

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.*;

public class Main {
    public static final int WIN_WIDTH= 1280;
    public static final int WIN_HEIGHT=720;
    private SortVisualizer sortVisualizer;

    private JFrame window;

    public Main(){

        //NOT YET OPTIMIZED
        window = new JFrame("Algorithm Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setResizable(false);
        sortVisualizer = new SortVisualizer();
        window.getContentPane().add(sortVisualizer);
        window.pack();
        window.setVisible(true);

        //operations
        sortVisualizer.shuffle();
        sortVisualizer.resetColors();
        //highlightArrays(20);
        //sortVisualizer.resetColors();
    }
    public static void main(String[] args)  {
        Main main = new Main();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
