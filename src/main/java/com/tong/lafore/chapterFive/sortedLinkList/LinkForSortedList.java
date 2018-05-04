package com.tong.lafore.chapterFive.sortedLinkList;

public class LinkForSortedList {

    public long dData;
    public LinkForSortedList next;

    public LinkForSortedList(long dData) {
        this.dData = dData;
    }

    public void displayLink(){
        System.out.println(dData+" ");
    }
}
