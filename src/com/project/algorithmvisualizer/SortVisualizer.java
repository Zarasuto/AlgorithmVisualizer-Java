package com.project.algorithmvisualizer;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

public class SortVisualizer extends JPanel{

    private int comparisons=0; //counts the number of changes in the array

    private final int BAR_WIDTH=1;
    private final int BAR_NUMS = Main.WIN_WIDTH/BAR_WIDTH;
    private final double MAX_HEIGHT=Main.WIN_HEIGHT*0.8;

    private static int[] arr;
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

    //-------------------------------------BAR OPERATIONS-----------------------------------------
    private void finaliseUpdate(long millisecondDelay, boolean isStep) {
        repaint();
        try {
            Thread.sleep(millisecondDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (isStep)
            comparisons++;
    }

    public void swap(int index1, int index2,long millisecondDelay, boolean isStep){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;

        barColor[index1]=-50;
        barColor[index2]=-50;

        finaliseUpdate(millisecondDelay,isStep);
    }
    public void updateSingle(int index, int value, long millisecondDelay, boolean isStep){
        arr[index]=value;

        barColor[index]=100;

        finaliseUpdate(millisecondDelay, isStep);
    }
    public void shuffle() {
        Random rng = new Random();
        for (int i = 0; i < arraySize(); i++) {
            int swapWithIndex = rng.nextInt(arraySize() - 1);
            swap(i, swapWithIndex, 5,false);
        }

    }
    //---------------------------------------------END---------------------------------------------

    //--------------------------------------------PAINT AND OVERRIDES---------------------------------------
    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        for(int i=0;i<BAR_NUMS;i++){

            int barheight=(int)Math.ceil(arr[i]*(MAX_HEIGHT/BAR_NUMS));
            int xbegin =((BAR_WIDTH)*(i));
            int ybegin= Main.WIN_HEIGHT-barheight;
            /**
             * If the barColor is recently changed, it will turn green. for every iteration, it will decrease by 5
             * then, after barcolor is below 190, it will turn red, but it will still decrease by 5 until it became zero and
             * turn to white
             */
            if(barColor[i]>0){
                int val=barColor[i]*2;
                graphics.setColor(new Color(255,255-val,255-val));
                barColor[i]-=5;
            }else if(barColor[i]<0){
                graphics.setColor(new Color(255,0,0));
                barColor[i]+=5;
            }else{
                graphics.setColor(new Color(255,255,255));
            }
            graphics.fillRect(xbegin,ybegin,BAR_WIDTH,barheight);
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Main.WIN_WIDTH,Main.WIN_HEIGHT);
    }

    //------------------------------------------------END-------------------------------------------------

    //------------------------------------------UTILITIES----------------------------------------
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

    public void highlightArrays(long millisecondDelay){
        for(int i=0;i<BAR_NUMS;i++){
            updateSingle(i, getValue(i), 5, false);
        }
    }

    public int getArrayMaxValue(){
        int max=0;
        for(int i=0;i<arraySize();i++){
            if(getValue(i)>max){
                max=getValue(i);
            }
        }
        return max;
    }
    public int getArrayChanges(){
        return comparisons;
    }
}
