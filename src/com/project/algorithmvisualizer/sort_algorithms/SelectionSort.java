package com.project.algorithmvisualizer.sort_algorithms;

import com.project.algorithmvisualizer.SortVisualizer;

public class SelectionSort implements sortAlgorithms{
    private static final long DEFAULT_DELAY=2;

    private long delay=DEFAULT_DELAY;

    @Override
    public void setDelay(long millisecond) {
        delay=millisecond;
    }

    @Override
    public void runSort(SortVisualizer array) {
        for(int i=0;i<array.arraySize();i++){
            int min_index=i;
            for(int j=i+1;j<array.arraySize();j++){
                if(array.getValue(j)<array.getValue(min_index)){
                    min_index=j;
                }
                array.updateSingle(j,array.getValue(j),delay,true);
            }
            array.swap(i,min_index,delay,true);
        }
    }

    @Override
    public String toString(){
        return "Selection Sort";
    }
}
