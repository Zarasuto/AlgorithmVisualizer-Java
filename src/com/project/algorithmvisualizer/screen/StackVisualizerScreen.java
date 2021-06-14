package com.project.algorithmvisualizer.screen;



import com.project.algorithmvisualizer.StackVisualizer;
import com.project.algorithmvisualizer.NodeObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StackVisualizerScreen extends Screen {

    private StackVisualizer stackVisualizer;
    private StackMenu stackMenu;

    public StackVisualizerScreen(MainScreen app) {
        super(app);
        setupGUI();
    }
    private void setupGUI(){
        setLayout(new BorderLayout());
        stackVisualizer = new StackVisualizer();
        stackMenu = new StackMenu();
        add(stackVisualizer, BorderLayout.CENTER);
        add(stackMenu,BorderLayout.PAGE_START);
        addListeners();
    }
    private void addListeners(){
        stackMenu.getPopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stackVisualizer.getStack().pop();
                repaint();
            }
        });
        stackMenu.getPushButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stackVisualizer.getStack().push(new NodeObject(stackMenu.getStackInput().getText()));
                repaint();
            }
        });
        stackMenu.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stackVisualizer.getStack().clear();
                repaint();
            }
        });
        stackMenu.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToMenu();
            }
        });
    }

    @Override
    public void startOperation() {
    }

    @Override
    public void backToMenu() {
        app.switchToTitle();
    }

    @Override
    public String getScreenName() {
        return "Stack";
    }
}
