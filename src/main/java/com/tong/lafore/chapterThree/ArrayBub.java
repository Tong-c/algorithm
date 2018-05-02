package com.tong.lafore.chapterThree;

public class ArrayBub {

    private long[] a;
    private int nElems;

    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        if(nElems > 0){
            for(int i = 0;i<nElems;i++){
                System.out.println(a[i]+" ");
            }
        }else {
            System.out.println(" ");
        }
    }


    public void bubbleSort(){
        int out,in;
        for(out = nElems - 1;out > 1;out --){
            for(in = 0;in < out;in++){
                if(a[in]>a[in + 1]){
                    swap(in ,in + 1);
                }
            }
        }
    }


    private void swap(int in, int i) {
        long temp = a[in];
        a[in] = a[i];
        a[i] = temp;

    }





}
