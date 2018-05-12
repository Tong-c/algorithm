package com.tong.lafore.chapterSix;

public class MergeSortApp {

    public static void main(String[] args) {
        int maxSize = 100;
        DArray arr;
        arr = new DArray(maxSize);

        arr.insert(29);
        arr.insert(34);
        arr.insert(23);
        arr.insert(2);
        arr.insert(5);
        arr.insert(296);
        arr.insert(342);
        arr.insert(2);
        arr.insert(9);
        arr.insert(21);
        arr.insert(35);
        arr.insert(56);
        arr.insert(30);
        arr.insert(41);
        arr.insert(76);

        arr.display();

        arr.mergeSort();

        arr.display();

    }
}
