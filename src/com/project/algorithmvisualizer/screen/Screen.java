package com.project.algorithmvisualizer.screen;

import com.project.algorithmvisualizer.Main;

import javax.swing.*;

public abstract class Screen extends JPanel {
    protected MainScreen app;

    public Screen(MainScreen app){
        this.app=app;
    }

    public abstract void startOperation();
    public abstract void backToMenu();
    public abstract String getScreenName();
}
