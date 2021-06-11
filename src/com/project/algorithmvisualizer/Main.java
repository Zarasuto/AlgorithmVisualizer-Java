package com.project.algorithmvisualizer;

import com.project.algorithmvisualizer.sort_algorithms.BubbleSort;
import com.project.algorithmvisualizer.sort_algorithms.MergeSort;
import com.project.algorithmvisualizer.sort_algorithms.SelectionSort;
import com.project.algorithmvisualizer.sort_algorithms.sortAlgorithms;

import javax.swing.JFrame;
import java.util.ArrayList;


public class Main {
    public static final int WIN_WIDTH= 1280;
    public static final int WIN_HEIGHT=720;

    private SortVisualizer sortVisualizer;
    ArrayList<sortAlgorithms> algorithms;

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
        waitAndShuffle();
        new MergeSort().runSort(sortVisualizer);
        sortVisualizer.highlightArrays(20);
        sortVisualizer.resetColors();

        /*new SelectionSort().runSort(sortVisualizer);
        sortVisualizer.highlightArrays(30);
        sortVisualizer.resetColors();
        waitAndShuffle();
        new BubbleSort().runSort(sortVisualizer);
        sortVisualizer.highlightArrays(10);
        sortVisualizer.resetColors();*/

    }
    public static void main(String[] args)  {
        Main main = new Main();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void waitAndShuffle(){
        try {
            Thread.sleep(2000);
            sortVisualizer.shuffle();
            sortVisualizer.resetColors();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
