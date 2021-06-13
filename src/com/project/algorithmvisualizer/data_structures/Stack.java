package com.project.algorithmvisualizer.data_structures;


import java.util.Iterator;

public class Stack implements Iterable{
    StackNode top;
    private int size=0;
    private class StackNode{
        NodeObject data;
        StackNode next;
        public StackNode(NodeObject data){
            this.data=data;
            next=null;
        }
    }
    public void push(NodeObject data){
        StackNode temp = new StackNode(data);
        if(size==42){
            return;
        }
        if(top==null){
            top=temp;
            size++;
            return;
        }
        temp.next=top;
        top=temp;
        size++;
    }

    public NodeObject peek(){
        return top.data;
    }

    public void pop(){
        if(top==null){
            return;
        }
        top=top.next;
        size--;
    }

    public void clear(){
        while(top!=null){
            top=top.next;
        }
        size=0;
    }

    public int getSize(){
        return size;
    }
    @Override
    public Iterator<NodeObject> iterator(){
        Iterator<NodeObject> it = new Iterator<NodeObject>() {

            private StackNode temp = top;

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
}
