package com.tong.lafore.chapterFive.linkListStackAndQueue;

public class LinkStack {

    private LinkListForStackAndQueue theList;

    public LinkStack() {
        this.theList = new LinkListForStackAndQueue();
    }

    public void push(long j){
        theList.insertFirst(j);
    }

    public long pop(){
        return theList.deleteFirst();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void displayStack(){
        System.out.println("Stack (top-->bottom):");
        theList.displayList();
    }


}
