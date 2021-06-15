package com.project.algorithmvisualizer.screen;

import javax.swing.*;
import java.awt.*;

public class StackMenu extends JPanel {
    public static final int MENU_WIDTH= 227;
    public static final int MENU_HEIGHT= 54;
    private JPanel menu;
    private JTextField StackInput;
    private JButton pushButton;
    private JButton popButton;
    private JButton clearButton;
    private JButton backButton;

    public StackMenu(){
        setupGUI();
    }
    private void setupGUI(){
        setBackground(Color.black);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        menu.setSize(MENU_WIDTH,MENU_HEIGHT);
        menu.setBackground(Color.black);

        add(menu);
    }

    public JTextField getStackInput() {
        return StackInput;
    }

    public JButton getPushButton() {
        return pushButton;
    }

    public JButton getPopButton() {
        return popButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
