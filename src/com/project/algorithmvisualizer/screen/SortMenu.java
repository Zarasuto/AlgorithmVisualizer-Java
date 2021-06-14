package com.project.algorithmvisualizer.screen;

import com.project.algorithmvisualizer.SortVisualizer;
import com.project.algorithmvisualizer.sort_algorithms.*;

import javax.swing.*;
import java.awt.*;

public class SortMenu extends JPanel {
    public static final int MENU_WIDTH= 227;
    public static final int MENU_HEIGHT= 54;

    private JSlider DelaySizePicker;
    private JComboBox<sortAlgorithms> AlgorithmPicker;
    private JButton startButton;
    private JPanel menu;
    private JButton BACKButton;
    private JTextField SortInput;
    private JButton addButton;
    private JButton clearButton;

    public SortMenu(){
        setupGUI();
    }

    private void setupGUI(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        menu.setSize(MENU_WIDTH,MENU_HEIGHT);

        //background colors
        setBackground(Color.black);
        menu.setBackground(Color.black);
        DelaySizePicker.setBackground(Color.black);

        DelaySizePicker.setValue((int) sortAlgorithms.DEFAULT_DELAY);

        populateComboBox();
        add(menu);
    }
    private void populateComboBox(){
        AlgorithmPicker.addItem(new BubbleSort());
        AlgorithmPicker.addItem(new MergeSort());
        AlgorithmPicker.addItem(new SelectionSort());
    }


    public JSlider getDelaySizePicker() {
        return DelaySizePicker;
    }

    public JComboBox<sortAlgorithms> getAlgorithmPicker() {
        return AlgorithmPicker;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getBACKButton() {
        return BACKButton;
    }

    public JTextField getSortInput() {
        return SortInput;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
}
