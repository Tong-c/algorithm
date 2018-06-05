package com.tong.lafore.chapterEleven.hashTableInChain;

public class Link {

    private int iData;
    public Link next;

    public Link(int it){
        iData = it;
    }

    public int getKey(){
        return iData;
    }

    public void displayLink(){
        System.out.print(iData + " ");
    }
}
