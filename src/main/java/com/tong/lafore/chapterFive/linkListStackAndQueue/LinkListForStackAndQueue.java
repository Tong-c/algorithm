package com.tong.lafore.chapterFive.linkListStackAndQueue;

import com.tong.lafore.chapterFive.linkListStackAndQueue.LinkForStackAndQueue;

public class LinkListForStackAndQueue {

    private LinkForStackAndQueue first;

    public void LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(long dd) {
        LinkForStackAndQueue newLink = new LinkForStackAndQueue(dd);
        newLink.next = first;
        first = newLink;
    }


    public long deleteFirst() {
        LinkForStackAndQueue temp = first;
        first = first.next;
        return temp.dData;
    }


    public LinkForStackAndQueue find(int key) {
        LinkForStackAndQueue current = first;
        while (current.dData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public LinkForStackAndQueue delete(int key) {

        LinkForStackAndQueue current = first;
        LinkForStackAndQueue previous = first;

        while (current.dData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }


    public void displayList() {
        System.out.println("List (first-->last):");
        LinkForStackAndQueue current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;

        }
        System.out.println("");

    }

}
