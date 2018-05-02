package com.tong.lafore.chapterFive;

public class Link {

    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        this.iData = id;
        this.dData = dd;
    }

    public void displayLink(){
        System.out.println("{" + iData + "," + dData + "}");
    }
}
