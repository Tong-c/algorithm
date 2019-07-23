package com.tong.lafore.chapterFive.linkListStackAndQueue;

import com.tong.lafore.chapterFive.firstLastLinkList.FirstLastLinkList;

public class LinkQueue {

    private FirstLastLinkList theList;

    public LinkQueue() {
        theList = new FirstLastLinkList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.inserLast(j);
    }

    public long remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.println("Queue (front-->rear):");
        theList.displayList();
    }

}
