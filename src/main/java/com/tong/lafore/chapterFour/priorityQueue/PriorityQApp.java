package com.tong.lafore.chapterFour.priorityQueue;

public class PriorityQApp {


    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(10);
        thePQ.insert(50);
        thePQ.insert(20);

        while (!thePQ.isEmpty()){
            long item = thePQ.remove();
            System.out.println(item + " ");
        }

        System.out.println("");
    }
}
