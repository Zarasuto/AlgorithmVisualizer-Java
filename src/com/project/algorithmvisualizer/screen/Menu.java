package com.project.algorithmvisualizer.screen;

import com.project.algorithmvisualizer.SortVisualizer;
import com.project.algorithmvisualizer.sort_algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JPanel {
    public static final int MENU_WIDTH= 227;
    public static final int MENU_HEIGHT= 54;

    private SortVisualizer sortVisualizer;
    private long algorithmDelay=0;
    private JSlider ArraySizePicker;
    private JSlider DelaySizePicker;
    private JComboBox<sortAlgorithms> AlgorithmPicker;
    private JButton startButton;
    private JPanel menu;

    public Menu(){
        setupGUI();
    }

    private void setupGUI(){
        sortVisualizer= new SortVisualizer();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.black);
        menu.setBackground(Color.black);
        menu.setSize(MENU_WIDTH,MENU_HEIGHT);
        ArraySizePicker.setBackground(Color.black);
        DelaySizePicker.setBackground(Color.black);
        populateComboBox();
        add(menu);
    }
    private void populateComboBox(){
        AlgorithmPicker.addItem(new BubbleSort());
        AlgorithmPicker.addItem(new MergeSort());
        AlgorithmPicker.addItem(new SelectionSort());
    }
}
