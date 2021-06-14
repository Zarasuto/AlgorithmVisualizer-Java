package com.project.algorithmvisualizer.sort_algorithms;

import com.project.algorithmvisualizer.NodeObject;
import com.project.algorithmvisualizer.SortVisualizer;


public class MergeSort implements sortAlgorithms{
    public static final long DEFAULT_DELAY=2;

    private long delay=DEFAULT_DELAY;

    @Override
    public void setDelay(long millisecond) {
        delay=millisecond;
    }

    @Override

    public void runSort(SortVisualizer array) {
        mergeSort(array,0,array.arraySize()-1);
    }

    public void mergeSort(SortVisualizer array,int leftindex,int rightindex){

        if(leftindex<rightindex){
            int middleindex=(leftindex+rightindex)/2;

            mergeSort(array,leftindex,middleindex);
            mergeSort(array,middleindex+1,rightindex);

            merge(array,leftindex,middleindex,rightindex);
        }
    }


    public void merge(SortVisualizer array,int leftindex, int middleindex, int rightindex){
        int leftsize=middleindex-leftindex+1;
        int rightsize=rightindex-middleindex;

        NodeObject[] left_temp_array= new NodeObject[leftsize];
        NodeObject[] right_temp_array = new NodeObject[rightsize];

        for(int i=0;i<leftsize;i++){
            left_temp_array[i]=array.getValue(leftindex+i);
        }
        for(int i=0;i<rightsize;i++){
            right_temp_array[i]=array.getValue(middleindex+1+i);
        }

        int i=0,j=0,k=leftindex;

        while(i<leftsize && j<rightsize){
            if(left_temp_array[i].getFirstCharacterValue()<=right_temp_array[j].getFirstCharacterValue()){
                array.updateSingle(k,left_temp_array[i],delay,true);
                i++;
            }else{
                array.updateSingle(k,right_temp_array[j],delay,true);
                j++;
            }
            k++;
        }

        while(i<leftsize){
            array.updateSingle(k,left_temp_array[i],delay,false);
            i++;
            k++;
        }

        while(j<rightsize){
            array.updateSingle(k,right_temp_array[j],delay,false);
            j++;
            k++;
        }
    }
    @Override
    public String toString(){
        return "Merge Sort";
    }
}
