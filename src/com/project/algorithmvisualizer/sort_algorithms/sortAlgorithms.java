package com.project.algorithmvisualizer.sort_algorithms;

import com.project.algorithmvisualizer.SortVisualizer;

public interface sortAlgorithms {
    public static long DEFAULT_DELAY=2;
    public void setDelay(long millisecond);
    public void runSort(SortVisualizer array);
}
