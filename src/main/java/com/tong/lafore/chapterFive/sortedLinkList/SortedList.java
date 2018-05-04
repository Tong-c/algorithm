package com.tong.lafore.chapterFive.sortedLinkList;

//有序鏈表
public class SortedList {

    private LinkForSortedList first;

    public SortedList(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(long key){
        LinkForSortedList newLink = new LinkForSortedList(key);
        LinkForSortedList previous = null;
        LinkForSortedList current = first;

        while (current != null && key > current.dData){
            previous = current;
            current = current.next;
        }

        if(previous == null){
            first = newLink;
        }else {
            previous.next = newLink;
        }

        newLink.next = current;
    }

}
