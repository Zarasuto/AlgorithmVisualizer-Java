package com.project.algorithmvisualizer.screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

        try {
            ClassLoader loader = getClass().getClassLoader();
            BufferedImage image = ImageIO.read(new File(loader.getResource("logo.png").getFile()));
            JLabel label = new JLabel(new ImageIcon(image));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(label,BorderLayout.PAGE_START);
        } catch (IOException e) {
            System.out.println("Unable to load logo");
        }

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
