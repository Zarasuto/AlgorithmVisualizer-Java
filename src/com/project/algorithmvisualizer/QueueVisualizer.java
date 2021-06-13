package com.project.algorithmvisualizer;

import com.project.algorithmvisualizer.data_structures.NodeObject;
import com.project.algorithmvisualizer.data_structures.Queue;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.project.algorithmvisualizer.Main.WIN_HEIGHT;
import static com.project.algorithmvisualizer.Main.WIN_WIDTH;

public class QueueVisualizer extends JPanel {
    private static final int POLY_SIZE = 4;
    private Queue queue;

    public QueueVisualizer(){
        setBackground(Color.gray);
        queue = new Queue();
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        int beginx=100;
        int beginy=100;

        drawTitle(graphics);

        Iterator<NodeObject> iterator = queue.iterator();
        NodeObject prev_node;

        try{
            prev_node = queue.peek();
        }catch(NullPointerException exception){
            prev_node = null;
        }
        int FRONT_X=beginx+35,FRONT_y=beginy+70;
        while(iterator.hasNext() && WIN_HEIGHT-beginy>100){

            graphics.setFont(new Font("Monospaced", Font.BOLD, 15));
            graphics.drawString("FRONT",FRONT_X,FRONT_y);

            NodeObject node = iterator.next();
            node.setGraphics(graphics);

            if(prev_node.equals(node)){
                node.drawNode(beginx,beginy,NodeObject.NODE_WIDTH,NodeObject.NODE_HEIGHT);
            }else{
                node.drawNode(beginx,beginy,NodeObject.NODE_WIDTH,NodeObject.NODE_HEIGHT);
                drawArrow(g,prev_node.getHeadX(), prev_node.getHeadY(), node.getTailX(), node.getTailY());
            }

            prev_node=node;
            beginx+=150;
            if(WIN_WIDTH-beginx<170){
                beginx=100;
                beginy+=100;
            }
        }
        try{
            graphics.drawString("REAR",prev_node.getPOS_X()+35,prev_node.getPOS_Y()+70);
        }catch(NullPointerException exception){

        }
    }
    private void drawTitle(Graphics2D graphics){
        Map<RenderingHints.Key, Object> renderingHints = new HashMap<>();
        renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.addRenderingHints(renderingHints);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Monospaced", Font.BOLD, 40));
        graphics.drawString("Queue", WIN_WIDTH/2-50, 30);
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
    public Queue getQueue(){
        return queue;
    }
}
