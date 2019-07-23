package com.tong.lafore.chapterFive.iterator;

public class Link {

    public long dData;
    public Link next;

    public Link(long dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }

}
