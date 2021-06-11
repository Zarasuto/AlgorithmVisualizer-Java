package com.project.algorithmvisualizer;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JPanel;

import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class SortVisualizer extends JPanel{

    private int comparisons=0; //counts the number of changes in the array
    private String algorithmName="";
    private long algorithm_delay=0;

    private static final int BAR_WIDTH=5;
    private static final int BAR_NUMS = WIN_WIDTH/BAR_WIDTH;
    private final double MAX_HEIGHT=WIN_HEIGHT*0.8;

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
            swap(i, swapWithIndex, 3,false);
        }

    }
    //---------------------------------------------END---------------------------------------------

    //--------------------------------------------PAINT AND OVERRIDES---------------------------------------
    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);

        Map<RenderingHints.Key, Object> renderingHints = new HashMap<>();
        renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.addRenderingHints(renderingHints);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Monospaced", Font.BOLD, 20));
        graphics.drawString(" Current algorithm: " + algorithmName, 10, 30);
        graphics.drawString("Current step delay: " + algorithm_delay + "ms", 10, 50);
        graphics.drawString("       Comparisons: " + comparisons, 10, 70);

        drawBars(graphics);
    }
    private void drawBars(Graphics2D graphics){
        for(int i=0;i<BAR_NUMS;i++){

            int barheight=(int)Math.ceil(arr[i]*(MAX_HEIGHT/BAR_NUMS));
            int xbegin =((BAR_WIDTH)*(i));
            int ybegin= WIN_HEIGHT-barheight;
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
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
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

    @Override
    public void setName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public void setDelay(long algorithm_delay){ this.algorithm_delay=algorithm_delay;}
}
