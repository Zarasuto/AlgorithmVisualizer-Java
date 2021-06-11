package com.project.algorithmvisualizer.sort_algorithms;


import com.project.algorithmvisualizer.SortVisualizer;

public class BubbleSort implements sortAlgorithms{

    @Override
    public void runSort(SortVisualizer array) {

        for(int i=0;i<array.arraySize();i++){
            for(int j=0;j< array.arraySize()-i-1;j++){
                if(array.getValue(j)>array.getValue(j+1)){
                    array.swap(j,j+1,2,true);
                }else{
                    array.updateSingle(j,array.getValue(j),2,true);
                }
            }
        }

    }
}
