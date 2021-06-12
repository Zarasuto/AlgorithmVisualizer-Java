package com.project.algorithmvisualizer.screen;


import javax.swing.JPanel;
import java.awt.Dimension;


import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class MainScreen extends JPanel {

    public MainScreen(){
        setupGUI();
    }
    private void setupGUI(){
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }
}
