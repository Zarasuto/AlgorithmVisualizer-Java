package com.project.algorithmvisualizer;

import com.project.algorithmvisualizer.data_structures.NodeObject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Stack;

import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class StackVisualizer extends JPanel {
    private static final int POLY_SIZE = 4;

    private Stack<NodeObject> stack;
    public StackVisualizer(){
    }

    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        NodeObject node1 = new NodeObject(graphics);
        NodeObject node2 = new NodeObject(graphics);
        node1.drawNode(50,100,NodeObject.NODE_WIDTH,NodeObject.NODE_HEIGHT);
        node2.drawNode(250,100,NodeObject.NODE_WIDTH,NodeObject.NODE_HEIGHT);

        drawArrow(g,node1.getHeadX(),node1.getHeadY(),node2.getTailX(),node1.getTailY());
    }

    void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-POLY_SIZE, len-POLY_SIZE, len},
                new int[] {0, -POLY_SIZE, POLY_SIZE, 0}, 4);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }
}
