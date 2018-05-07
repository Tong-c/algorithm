package com.tong.lafore.chapterFive.doublyLinkList;

public class DoublyLinkedApp {

    public static void main(String[] args) {
        DoublyLinkList theList = new DoublyLinkList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);

        theList.displayForward();

        theList.insertAfter(22,77);
        theList.insertAfter(33,88);

        theList.displayForward();
    }
}
