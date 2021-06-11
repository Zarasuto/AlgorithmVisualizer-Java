package com.project.algorithmvisualizer.screen;

import com.project.algorithmvisualizer.SortVisualizer;

import javax.swing.*;
import java.awt.*;

import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class MainScreen extends JPanel {

    private Menu menu;
    private SortVisualizer sortVisualizer;

    public MainScreen(){
        setupGUI();

    }
    private void setupGUI(){
        menu = new Menu();
        sortVisualizer = new SortVisualizer();

        setLayout(new BorderLayout());
        add(menu,BorderLayout.PAGE_START);
        add(sortVisualizer,BorderLayout.CENTER);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT+menu.MENU_HEIGHT);
    }
}
