package com.project.algorithmvisualizer.screen;



import com.project.algorithmvisualizer.QueueVisualizer;
import com.project.algorithmvisualizer.NodeObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QueueVisualizerScreen extends Screen {

    private QueueVisualizer queueVisualizer;
    private QueueMenu queueMenu;

    public QueueVisualizerScreen(MainScreen app) {
        super(app);
        setupGUI();
    }
    private void setupGUI(){
        setLayout(new BorderLayout());
        queueVisualizer = new QueueVisualizer();
        queueMenu = new QueueMenu();
        add(queueVisualizer, BorderLayout.CENTER);
        add(queueMenu,BorderLayout.PAGE_START);
        addListeners();
    }
    private void addListeners(){
        queueMenu.getDequeueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queueVisualizer.getQueue().deQueue();
                repaint();
            }
        });
        queueMenu.getEnqueueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queueVisualizer.getQueue().enQueue(new NodeObject(queueMenu.getQueueInput().getText()));
                repaint();
            }
        });
        queueMenu.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queueVisualizer.getQueue().clear();
                repaint();
            }
        });
        queueMenu.getBackButton().addActionListener(new ActionListener() {
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
        return "Queue";
    }
}
