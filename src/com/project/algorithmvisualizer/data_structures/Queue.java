package com.project.algorithmvisualizer.data_structures;

import java.util.Iterator;

public class Queue implements Iterable<NodeObject>{
    QueueNode front,rear;
    private int size=0;

    private class QueueNode{
        NodeObject data;
        QueueNode next;
        public QueueNode(NodeObject data){
            this.data = data;
            next=null;
        }
    }

    public void enQueue(NodeObject data){
        if(size==42){
            return;
        }

        QueueNode temp = new QueueNode(data);
        if(rear==null){
            front=rear=temp;
            size++;
            return;
        }
        rear.next=temp;
        rear=temp;
        size++;
    }

    public void deQueue(){
        if(front==null){
            return;
        }else{
            front=front.next;
            if(front==null){
                rear=null;
            }
        }
        size--;
    }

    public NodeObject peek(){
        return front.data;
    }

    public void clear(){
        while(front!=null){
            front=front.next;
        }
        front=rear=null;
        size=0;
    }

    @Override
    public Iterator<NodeObject> iterator(){
        Iterator<NodeObject> it = new Iterator<NodeObject>() {

            private QueueNode temp = front;

            @Override
            public boolean hasNext() {
                if(temp==null){
                    return false;
                }else{
                    return true;
                }
            }

            @Override
            public NodeObject next(){
                NodeObject data = temp.data;
                temp=temp.next;
                return data;
            }
        };
        return it;
    }

    public int getSize(){
        return size;
    }
}
