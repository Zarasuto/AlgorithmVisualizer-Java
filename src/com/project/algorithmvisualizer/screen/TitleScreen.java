package com.project.algorithmvisualizer.screen;

import javax.swing.*;
import java.awt.*;

public class TitleScreen extends Screen{
    private JPanel container;
    private JButton pickSortButton;
    private JButton pickStackButton;
    private JButton pickQueueButton;

    public TitleScreen(MainScreen app){
        super(app);
        setupGUI();
    }

    public void setupGUI(){
        setLayout(new BorderLayout());
        container.setBackground(Color.black);
        add(container,BorderLayout.CENTER);
    }

    public JButton getPickSortButton() {
        return pickSortButton;
    }

    public JButton getPickStackButton() {
        return pickStackButton;
    }

    public JButton getPickQueueButton() {
        return pickQueueButton;
    }

    @Override
    public void startOperation() { }

    @Override
    public void backToMenu(){}

    @Override
    public String getScreenName() {
        return "Title Screen";
    }
}
