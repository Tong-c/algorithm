package com.tong.lafore.chapterFive.firstLastLinkList;

public class FirstLastApp {

    public static void main(String[] args) {
        FirstLastLinkList theList = new FirstLastLinkList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.inserLast(11);
        theList.inserLast(33);
        theList.inserLast(55);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}
