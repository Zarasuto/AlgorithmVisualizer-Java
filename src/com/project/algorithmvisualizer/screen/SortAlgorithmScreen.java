package com.project.algorithmvisualizer.screen;

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

public class SortAlgorithmScreen extends JPanel implements Screen{

    private Menu menu;
    private SortVisualizer sortVisualizer;

    public SortAlgorithmScreen(){
        setupGUI();
    }

    private void setupGUI() {
        menu = new Menu();
        sortVisualizer = new SortVisualizer();
        setLayout(new BorderLayout());
        add(sortVisualizer,BorderLayout.CENTER);
        add(menu,BorderLayout.PAGE_START);
        addListener();

    }

    public void addListener(){
        menu.getArraySizePicker().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(menu.getStartButton().isEnabled()){
                    sortVisualizer.setBarNums(menu.getArraySizePicker().getValue());
                    sortVisualizer.setBarArray();
                    repaint();
                }
            }
        });
        menu.getDelaySizePicker().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sortVisualizer.setDelay(menu.getDelaySizePicker().getValue());
                sortAlgorithms algorithm = menu.getAlgorithmPicker().getItemAt(menu.getAlgorithmPicker().getSelectedIndex());
                algorithm.setDelay(menu.getDelaySizePicker().getValue());
                repaint();
            }
        });
        menu.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startOperation();
            }
        });
    }

    public void waitAndShuffle(){
        try {
            Thread.sleep(2000);
            sortVisualizer.shuffle();
            sortVisualizer.resetColors();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void startOperation() {
        SwingWorker<Void,Void> swingWorker=new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                menu.getStartButton().setEnabled(false);
                sortAlgorithms algorithm = menu.getAlgorithmPicker().getItemAt(menu.getAlgorithmPicker().getSelectedIndex());

                sortVisualizer.setName(algorithm.toString());
                algorithm.setDelay(menu.getDelaySizePicker().getValue());
                sortVisualizer.setDelay(menu.getDelaySizePicker().getValue());
                waitAndShuffle();

                algorithm.runSort(sortVisualizer);
                sortVisualizer.highlightArrays(2);
                sortVisualizer.resetColors();

                menu.getStartButton().setEnabled(true);

                return null;
            }
        };
        swingWorker.execute();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT+menu.MENU_HEIGHT);
    }

    @Override
    public void backToMenu() {

    }
}
