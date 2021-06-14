package com.project.algorithmvisualizer.screen;

import com.project.algorithmvisualizer.NodeObject;
import com.project.algorithmvisualizer.SortVisualizer;
import com.project.algorithmvisualizer.sort_algorithms.sortAlgorithms;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class SortAlgorithmScreen extends Screen{

    private SortMenu sortMenu;
    private SortVisualizer sortVisualizer;

    public SortAlgorithmScreen(MainScreen app){
        super(app);
        setupGUI();
    }

    private void setupGUI() {
        sortMenu = new SortMenu();
        sortVisualizer = new SortVisualizer();
        setLayout(new BorderLayout());
        add(sortVisualizer,BorderLayout.CENTER);
        add(sortMenu,BorderLayout.PAGE_START);
        addListener();
    }

    public void addListener(){
        sortMenu.getDelaySizePicker().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sortVisualizer.setDelay(sortMenu.getDelaySizePicker().getValue());
                sortAlgorithms algorithm = sortMenu.getAlgorithmPicker().getItemAt(sortMenu.getAlgorithmPicker().getSelectedIndex());
                algorithm.setDelay(sortMenu.getDelaySizePicker().getValue());
                repaint();
            }
        });
        sortMenu.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startOperation();
            }
        });

        sortMenu.getBACKButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToMenu();
            }
        });

        sortMenu.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortVisualizer.addItem(new NodeObject(sortMenu.getSortInput().getText()));
                sortMenu.getSortInput().setName("");
                repaint();
            }
        });
        sortMenu.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortVisualizer.setArray(42);
                repaint();
            }
        });
    }


    @Override
    public void startOperation() {
        SwingWorker<Void,Void> swingWorker=new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                sortMenu.getStartButton().setEnabled(false);
                sortMenu.getClearButton().setEnabled(false);
                sortMenu.getAddButton().setEnabled(false);

                sortAlgorithms algorithm = sortMenu.getAlgorithmPicker().getItemAt(sortMenu.getAlgorithmPicker().getSelectedIndex());

                sortVisualizer.setName(algorithm.toString());
                algorithm.setDelay(sortMenu.getDelaySizePicker().getValue());
                sortVisualizer.setDelay(sortMenu.getDelaySizePicker().getValue());

                algorithm.runSort(sortVisualizer);
                sortVisualizer.resetColors();

                sortMenu.getStartButton().setEnabled(true);
                sortMenu.getClearButton().setEnabled(true);
                sortMenu.getAddButton().setEnabled(true);

                return null;
            }
        };
        swingWorker.execute();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT+ sortMenu.MENU_HEIGHT);
    }

    @Override
    public void backToMenu() {
        app.switchToTitle();
    }

    @Override
    public String getScreenName() {
        return "Sorting Screen";
    }
}
