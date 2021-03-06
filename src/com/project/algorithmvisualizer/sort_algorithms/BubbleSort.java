package com.project.algorithmvisualizer.sort_algorithms;


import com.project.algorithmvisualizer.SortVisualizer;

public class BubbleSort implements sortAlgorithms{

    public static final long DEFAULT_DELAY=2;

    private long delay=DEFAULT_DELAY;

    @Override
    public void setDelay(long millisecond) {
        delay=millisecond;
    }


    @Override
    public void runSort(SortVisualizer array) {

        RESET: for(int i=0;i<array.arraySize();i++){
            for(int j=0;j< array.arraySize()-i-1;j++){
                if(array.getValue(j).getFirstCharacterValue()>array.getValue(j+1).getFirstCharacterValue()){
                    array.swap(j,j+1,delay,true);
                }else{
                    array.updateSingle(j,array.getValue(j),delay,true);
                }
            }
        }
    }
    @Override
    public String toString(){
        return "Bubble Sort";
    }
}
