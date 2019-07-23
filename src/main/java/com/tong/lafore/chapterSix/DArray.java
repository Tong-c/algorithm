package com.tong.lafore.chapterSix;

public class DArray {

    private long[] theArray;
    private int nElemes;

    public DArray(int max) {
        this.theArray = new long[max];
        nElemes = 0;
    }

    public void insert(long value) {
        theArray[nElemes] = value;
        nElemes++;
    }

    public void display() {
        for (int j = 0; j < nElemes; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println("");
    }

    public void mergeSort() {
        long[] workSpace = new long[nElemes];
        recMergeSort(workSpace, 0, nElemes - 1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(long[] workSpace, int lowerPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowerPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        while (lowerPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowerPtr] < theArray[highPtr]) {
                workSpace[j++] = theArray[lowerPtr++];
            } else {
                workSpace[j++] = theArray[highPtr++];
            }
        }

        while (lowerPtr <= mid) {
            workSpace[j++] = theArray[lowerPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = theArray[highPtr++];
        }

        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }
    }
}
