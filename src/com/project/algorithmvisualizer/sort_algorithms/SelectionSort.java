package com.project.algorithmvisualizer.sort_algorithms;

import com.project.algorithmvisualizer.SortVisualizer;

public class SelectionSort implements sortAlgorithms{


    @Override
    public void runSort(SortVisualizer array) {
        for(int i=0;i<array.arraySize();i++){
            int min_index=i;
            for(int j=i+1;j<array.arraySize();j++){
                if(array.getValue(j)<array.getValue(min_index)){
                    min_index=j;
                }
                array.updateSingle(j,array.getValue(j),2,true);
            }
            array.swap(i,min_index,2,true);
        }
    }
}
