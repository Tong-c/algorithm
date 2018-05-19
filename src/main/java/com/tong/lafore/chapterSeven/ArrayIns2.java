package com.tong.lafore.chapterSeven;

/**
 * 三數據項取中劃分快速排序
 */
public class ArrayIns2 {

    private long[] theArray;
    private int nElems;

    public ArrayIns2(int max){
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }

    public void display(){
        System.out.print("A=");
        for(int j = 0;j<nElems;j++){
            System.out.print(theArray[j] + " ");
        }
        System.out.println("");
    }

    public void quickSort(){
        recQuickSort(0,nElems - 1);
    }

    private void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if(size <= 3){
            manualSort(left,right);
        }else {
            long median = medianOf3(left,right);
            int partition = partitionIt(left,right,median);
            recQuickSort(left,partition - 1);
            recQuickSort(partition + 1,right);
        }
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true){
            while (theArray[++leftPtr] < pivot){

            }

            while (theArray[--rightPtr] > pivot){

            }

            if(leftPtr > rightPtr){
                break;
            } else {
                swap(leftPtr,rightPtr);
            }

        }

        swap(leftPtr,right - 1);
        return leftPtr;
    }


    private long medianOf3(int left, int right) {
        int center = (left + right)/2;
        if(theArray[left] > theArray[center]){
            swap(left,center);
        }
        if(theArray[left] > theArray[right]){
            swap(left,right);
        }
        if(theArray[center] > theArray[right]){
            swap(center,right);
        }

        swap(center,right - 1);
        return theArray[right - 1];
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if(size <= 1){
            return;
        }
        if (size == 2){
            if(theArray[left] > theArray[right]){
                swap(left,right);
            }
            return;
        }else {
            if (theArray[left] > theArray[right - 1]){
                swap(left,right - 1);
            }
            if(theArray[left] > theArray[right]){
                swap(left,right);
            }
            if(theArray[right - 1] > theArray[right]){
                swap(right -1 ,right);
            }
        }
    }

    private void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;

    }
}
