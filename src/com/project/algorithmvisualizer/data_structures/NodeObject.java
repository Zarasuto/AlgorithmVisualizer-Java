package com.project.algorithmvisualizer.data_structures;

import java.awt.*;

public class NodeObject {
    private String name="";

    public static final int NODE_WIDTH=100;
    public static final int NODE_HEIGHT=50;

    private int HEAD_X;
    private int HEAD_Y;
    private int TAIL_X;
    private int TAIL_Y;

    private Graphics2D graphics;

    public NodeObject(Graphics2D graphics){
        this.graphics=graphics;
    }
    public void drawNode(int beginx,int beginy,int width, int height){
        graphics.drawRect(beginx,beginy,width,height);

        //draws a box inside a rectangle to contain an X
        graphics.drawRect(beginx+width,beginy,width/4,height);

        //Draws an X
        graphics.drawLine(beginx+width,beginy,beginx+width+(width/4),beginy+height);
        graphics.drawLine(beginx+width+(width/4),beginy,beginx+width,beginy+height);

        //Set Coordinates for Head and Tail
        setHeadX(beginx+width+(width/4));
        setHeadY((beginy)+(height/2));
        setTailX(beginx);
        setTailY((beginy)+(height/2));
    }


    public void setName(String name){
        this.name = name;
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
}
