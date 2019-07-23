package com.tong.lafore.chapterFive.firstLastLinkList;

import com.tong.lafore.chapterFive.firstLastLinkList.FirstLastLink;

/**
 * 雙端鏈表
 */
public class FirstLastLinkList {

    private FirstLastLink first;
    private FirstLastLink last;

    public FirstLastLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        FirstLastLink newLink = new FirstLastLink(dd);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void inserLast(long dd) {
        FirstLastLink newLink = new FirstLastLink(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }

        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List (first-->last): ");
        FirstLastLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }


}
