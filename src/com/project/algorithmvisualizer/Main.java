package com.project.algorithmvisualizer;

import com.project.algorithmvisualizer.screen.MainScreen;
import com.project.algorithmvisualizer.screen.SortAlgorithmScreen;
import com.project.algorithmvisualizer.sort_algorithms.MergeSort;
import com.project.algorithmvisualizer.sort_algorithms.sortAlgorithms;

import javax.swing.JFrame;
import java.util.ArrayList;


public class Main {
    public static final int WIN_WIDTH= 1280;
    public static final int WIN_HEIGHT=720;

    private MainScreen menu;
    private SortAlgorithmScreen sortAlgorithm;
    private JFrame window;

    public Main(){
        window = new JFrame("Algorithm Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }

    public void start(){
        menu = new MainScreen();
        window.setContentPane(menu);
        window.validate();
        window.pack();
    }


    public static void main(String[] args)  {
        Main main = new Main();
        main.start();
    }
}
