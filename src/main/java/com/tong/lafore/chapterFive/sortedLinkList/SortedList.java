package com.tong.lafore.chapterFive.sortedLinkList;

import com.tong.lafore.chapterFive.linkList.Link;

//有序鏈表
public class SortedList {

    private LinkForSortedList first;

    public SortedList(){
        first = null;
    }

    //用於對無序數組排序
    public SortedList(LinkForSortedList[] linkArr){
        first = null;
        for(int i = 0;i<linkArr.length;i++){
            insert(linkArr[i]);
        }
    }
    public boolean isEmpty(){
        return first == null;
    }


    public void insert(LinkForSortedList k){
        insert(k.dData);
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

    public LinkForSortedList remove(){
        LinkForSortedList temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first --> last):");
        LinkForSortedList current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");

    }

}
