package com.project.algorithmvisualizer.screen;


import javax.swing.*;
import java.awt.*;


import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class MainScreen extends JPanel {

    private CardLayout cardLayout;

    private JPanel card;

    private SortAlgorithmScreen sortAlgorithmScreen;

    public MainScreen(){
        setupGUI();
    }
    private void setupGUI(){
        card = new JPanel(new CardLayout());
        add(card);
        sortAlgorithmScreen = new SortAlgorithmScreen();
        cardLayout = (CardLayout) card.getLayout();
        //card.add(sortAlgorithmScreen,"Sort Algorithm");
        //cardLayout.show(card,"Sort Algorithm");
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT+Menu.MENU_HEIGHT);
    }
}
