package com.project.algorithmvisualizer;

import org.w3c.dom.Node;

import java.awt.*;
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


    private static final int DEFAULT_ARRAY_SIZE=42;

    private int ARRAY_SIZE=DEFAULT_ARRAY_SIZE;

    private NodeObject[] arr;
    private int[] barColor;

    public SortVisualizer(){
        setBackground(Color.black);
        setArray(ARRAY_SIZE);
        for(int i=0;i<ARRAY_SIZE;i++){
            barColor[i]=0;
        }
    }
    public void setArray(int size){
        arr = new NodeObject[size];
        barColor=new int[size];
    }
    public void addItem(NodeObject item){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==null){
                arr[i]=item;
                return;
            }
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
        NodeObject temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;

        barColor[index1]=10;
        barColor[index2]=10;

        finaliseUpdate(millisecondDelay,isStep);
    }
    public void updateSingle(int index, NodeObject value, long millisecondDelay, boolean isStep){
        arr[index]=value;

        barColor[index]=10;

        finaliseUpdate(millisecondDelay, isStep);
    }
    public void shuffle() {
        comparisons=0;
        Random rng = new Random();
        for (int i = 0; i < arraySize(); i++) {
            int swapWithIndex = rng.nextInt(arraySize() - 1);
            swap(i, swapWithIndex, 3,false);
        }
        comparisons=0;
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
        graphics.drawString("       Array Size : " + ARRAY_SIZE, 10, 70);
        graphics.drawString("       Comparisons: " + comparisons, 10, 90);

        drawNode(graphics);
    }

    private void drawNode(Graphics2D graphics){
        int beginx=100;
        int beginy=100;
        for(int i=0;i<arr.length;i++){
            try{
                arr[i].setGraphics(graphics);
                if(barColor[i]>0){
                    arr[i].highlightNode(beginx,beginy,NodeObject.NODE_WIDTH,NodeObject.NODE_HEIGHT);
                    barColor[i]-=10;
                }
                graphics.setColor(Color.white);
                arr[i].drawNode(beginx,beginy,NodeObject.NODE_WIDTH,NodeObject.NODE_HEIGHT);
                beginx+=150;
                if(WIN_WIDTH-beginx<170){
                    beginx=100;
                    beginy+=100;
                }
            }catch(NullPointerException exp){

            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }

    //------------------------------------------------END-------------------------------------------------

    //------------------------------------------UTILITIES----------------------------------------

    public int arraySize() {
        int size=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                size++;
            }
        }
        return size;
    }

    public NodeObject getValue(int index) {
        return arr[index];
    }

    public void resetColors() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            barColor[i] = 0;
        }
        comparisons=0;
        repaint();
    }

    @Override
    public void setName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public void setDelay(long algorithm_delay){ this.algorithm_delay=algorithm_delay;}

    public void setSize(int size){
        this.ARRAY_SIZE=size;
    }
}
