package com.project.algorithmvisualizer;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

public class SortVisualizer extends JPanel{

    private int arrayChanges; //counts the number of changes in the array

    private final int BAR_WIDTH=5;
    private final int BAR_NUMS = Main.WIN_WIDTH/BAR_WIDTH;

    private int[] arr;
    private int[] barColor;

    public SortVisualizer(){
        setBackground(Color.black);
        arr = new int[BAR_NUMS];
        barColor = new int[BAR_NUMS];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
            barColor[i]=0;
        }
    }

    private void finaliseUpdate(long millisecondDelay, boolean isChanged) {
        repaint();
        try {
            Thread.sleep(millisecondDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (isChanged)
            arrayChanges++;
    }

    public void swap(int index1, int index2,long millisecondDelay, boolean isChanged){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;

        barColor[index1]=120;
        barColor[index2]=120;

        finaliseUpdate(millisecondDelay,isChanged);
    }
    public void shuffle() {
        Random rng = new Random();
        for (int i = 0; i < arraySize(); i++) {
            int swapWithIndex = rng.nextInt(arraySize() - 1);
            swap(i, swapWithIndex, 2,false);
        }

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        for(int i=0;i<BAR_NUMS;i++){

            int barheight=arr[i]*2;
            int xbegin =((BAR_WIDTH)*(i));
            int ybegin= Main.WIN_HEIGHT-barheight;
            int val=barColor[i]*2;
            if(val>220){
                graphics.setColor(new Color(255-val,255,255-val));
            }else{
                graphics.setColor(new Color(255,255-val,255-val));
            }
            graphics.fillRect(xbegin,ybegin,BAR_WIDTH,barheight);
            if(barColor[i]>0){
                barColor[i]-=10;
            }
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Main.WIN_WIDTH,Main.WIN_HEIGHT);
    }
    public void resetColors() {
        for (int i = 0; i < BAR_NUMS; i++) {
            barColor[i] = 0;
        }
        repaint();
    }
    public int arraySize() {
        return arr.length;
    }

    public int getValue(int index) {
        return arr[index];
    }
    /**
     * Gets the max value of the array or Integer.MIN_VALUE if there isn't one.
     * @return the max value or Integer.MIN_VALUE.
     */
    public int getMaxValue() {
        return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
    }
}
