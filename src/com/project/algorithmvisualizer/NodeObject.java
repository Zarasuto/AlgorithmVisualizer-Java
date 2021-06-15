package com.project.algorithmvisualizer;

import java.awt.*;

public class NodeObject {
    private String name="";

    public static final int NODE_WIDTH=100;
    public static final int NODE_HEIGHT=50;

    private int HEAD_X;
    private int HEAD_Y;
    private int TAIL_X;
    private int TAIL_Y;

    private int POS_X;
    private int POS_Y;

    private Graphics2D graphics;

    public NodeObject(String Name){
        this.name = Name;
    }
    public void drawNode(int beginx,int beginy,int width, int height){
        graphics.drawRect(beginx,beginy,width,height);

        //draws a box inside a rectangle to contain an X
        graphics.drawRect(beginx+width,beginy,width/4,height);

        //Draws an X
        graphics.drawLine(beginx+width,beginy,beginx+width+(width/4),beginy+height);
        graphics.drawLine(beginx+width+(width/4),beginy,beginx+width,beginy+height);

        //Set Coordinates for Head, Tail and Position
        setHeadX(beginx+width+(width/4));
        setHeadY((beginy)+(height/2));
        setTailX(beginx);
        setTailY((beginy)+(height/2));
        setPOS_X(beginx);
        setPOS_Y(beginy);

        //Draw String for the data
        graphics.drawString(this.name,beginx+10,beginy+25);
    }

    public void highlightNode(int beginx,int beginy,int width, int height){
        graphics.setColor(Color.blue);
        graphics.fillRect(beginx,beginy,width,height);
    }

    public void setGraphics(Graphics2D graphics){
        this.graphics=graphics;
    }
    public int getHeadX() {
        return HEAD_X;
    }

    public void setHeadX(int headX) {
        HEAD_X = headX;
    }

    public int getHeadY() {
        return HEAD_Y;
    }

    public void setHeadY(int headY) {
        HEAD_Y = headY;
    }

    public int getTailX() {
        return TAIL_X;
    }

    public void setTailX(int tailX) {
        TAIL_X = tailX;
    }

    public int getTailY() {
        return TAIL_Y;
    }

    public void setTailY(int tailY) {
        TAIL_Y = tailY;
    }

    public int getPOS_X() {
        return POS_X;
    }

    public void setPOS_X(int POS_X) {
        this.POS_X = POS_X;
    }

    public int getPOS_Y() {
        return POS_Y;
    }

    public void setPOS_Y(int POS_Y) {
        this.POS_Y = POS_Y;
    }

    public String getName(){
        return this.name;
    }

    public int getFirstCharacterValue(){
        int value=0;
        try{
            value=Integer.parseInt(name);
        }catch(NumberFormatException exp){
            for(int i=0;i<name.length();i++){
                value+=name.charAt(i);
            }
        }
        return value;
    }
}
