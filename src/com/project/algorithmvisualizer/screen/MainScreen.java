package com.project.algorithmvisualizer.screen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

/**
 * This is where everything happens.
 * Main Screen is to allow to switch between panels.
 * From TitleScreen to Sorting Screen and Back
 */
public class MainScreen extends JPanel {

    private CardLayout cardLayout;

    private JPanel card;

    private SortAlgorithmScreen sortAlgorithmScreen;
    private TitleScreen titleScreen;
    private StackVisualizerScreen stackVisualizerScreen;

    public MainScreen(){
        setupGUI();
    }
    private void setupGUI(){
        setLayout(new BorderLayout());
        card = new JPanel(new CardLayout());
        cardLayout = (CardLayout) card.getLayout();
        setupScreens();

        add(card,BorderLayout.CENTER);
        card.add(titleScreen,titleScreen.getScreenName());
        card.add(sortAlgorithmScreen,sortAlgorithmScreen.getScreenName());
        card.add(stackVisualizerScreen,stackVisualizerScreen.getScreenName());

        addListeners();
        cardLayout.show(card,titleScreen.getScreenName());
    }

    private void setupScreens(){
        titleScreen = new TitleScreen(this);
        sortAlgorithmScreen = new SortAlgorithmScreen(this);
        stackVisualizerScreen = new StackVisualizerScreen(this);
    }

    /**
     * Button listeners of Title Screen
     * Switches between panels
     * Listener: Listens for an event
     */
    private void addListeners(){
        titleScreen.getPickSortButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(card,sortAlgorithmScreen.getScreenName());
            }
        });

        titleScreen.getPickStackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(card,stackVisualizerScreen.getScreenName());
            }
        });
        titleScreen.getPickQueueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void switchToTitle(){
        cardLayout.show(card,titleScreen.getScreenName());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT+ SortMenu.MENU_HEIGHT);
    }
}
