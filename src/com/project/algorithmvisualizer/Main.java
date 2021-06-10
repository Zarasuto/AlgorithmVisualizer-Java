package com.project.algorithmvisualizer;

import javax.swing.JFrame;
public class Main {
    public static final int WIN_WIDTH=1280;
    public static final int WIN_HEIGHT=720;

    private JFrame window;

    public Main(){
        window = new JFrame("Algorithm Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIN_WIDTH,WIN_HEIGHT);
        window.setVisible(true);
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}
