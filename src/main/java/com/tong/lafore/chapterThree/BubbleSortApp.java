package com.tong.lafore.chapterThree;

public class BubbleSortApp {

    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(100);

        arr.insert(29);
        arr.insert(2);
        arr.insert(298);
        arr.insert(13);
        arr.insert(34);
        arr.insert(5);
        arr.insert(9);
        arr.insert(35);
        arr.insert(47);
        arr.insert(10);
        arr.insert(100);
        arr.insert(35);

        arr.bubbleSort();
        arr.display();
    }
}
