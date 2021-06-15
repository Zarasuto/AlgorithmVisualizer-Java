package com.project.algorithmvisualizer.screen;

import javax.swing.*;
import java.awt.*;

public class QueueMenu extends JPanel {
    public static final int MENU_WIDTH= 227;
    public static final int MENU_HEIGHT= 54;
    private JPanel menu;
    private JTextField QueueInput;
    private JButton enqueueButton;
    private JButton dequeueButton;
    private JButton clearButton;
    private JButton backButton;

    public QueueMenu(){
        setupGUI();
    }
    private void setupGUI(){
        setBackground(Color.black);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        menu.setSize(MENU_WIDTH,MENU_HEIGHT);
        menu.setBackground(Color.black);

        add(menu);
    }

    public JTextField getQueueInput() {
        return QueueInput;
    }

    public JButton getEnqueueButton() {
        return enqueueButton;
    }

    public JButton getDequeueButton() {
        return dequeueButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
