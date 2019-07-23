package com.tong.lafore.chapterFive.firstLastLinkList;

public class FirstLastLink {

    public long dData;
    public FirstLastLink next;

    public FirstLastLink(long dd) {
        this.dData = dd;
    }

    public void displayLink() {
        System.out.println("{" + dData + "}");
    }
}
