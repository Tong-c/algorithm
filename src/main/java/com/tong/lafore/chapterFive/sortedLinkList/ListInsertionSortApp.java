package com.tong.lafore.chapterFive.sortedLinkList;

import com.tong.lafore.chapterFive.linkList.Link;

public class ListInsertionSortApp {

    //使用有序鏈表為數組排序
    public static void main(String[] args) {
        int size = 10;
        LinkForSortedList[] linkArray = new LinkForSortedList[size];

        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 99);
            LinkForSortedList newLink = new LinkForSortedList(n);
            linkArray[i] = newLink;
        }

        System.out.println("Unsorted array:");

        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].dData + " ");
        }
        System.out.println(" ");

        SortedList theSoredList = new SortedList(linkArray);

        for (int j = 0; j < size; j++) {
            linkArray[j] = theSoredList.remove();
        }

        System.out.print("Sorted TArray: ");
        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].dData + " ");
        }
        System.out.println("");
    }
}
