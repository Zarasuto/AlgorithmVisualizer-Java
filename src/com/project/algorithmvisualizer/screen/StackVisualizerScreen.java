package com.project.algorithmvisualizer.screen;



import com.project.algorithmvisualizer.StackVisualizer;

import javax.swing.*;
import java.awt.*;

import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class StackVisualizerScreen extends Screen {

    public StackVisualizerScreen(MainScreen app) {
        super(app);
        setupGUI();
    }
    private void setupGUI(){
        StackVisualizer stackVisualizer = new StackVisualizer();
        add(stackVisualizer, BorderLayout.CENTER);
    }
    @Override
    public void startOperation() {

    }

    @Override
    public void backToMenu() {

    }

    @Override
    public String getScreenName() {
        return "Stack";
    }
}
