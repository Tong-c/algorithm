package com.tong.lafore.chapterSeven;

public class QuickSortApp {

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);

        for(int j = 0;j<maxSize;j++){
            long n = (long) (Math.random() * 199);
            arr.insert(n);
        }

        arr.display();

        arr.quickSort();
        arr.display();
    }
}
