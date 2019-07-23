package com.tong.lafore.chapterFive.linkListStackAndQueue;

public class LinkForStackAndQueue {

    public long dData;
    public LinkForStackAndQueue next;

    public LinkForStackAndQueue(long dd) {
        this.dData = dd;
    }

    public void displayLink() {
        System.out.println("{" + dData + "}");
    }
}
