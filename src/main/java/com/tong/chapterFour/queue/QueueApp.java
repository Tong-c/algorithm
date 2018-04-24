package com.tong.chapterFour.queue;

public class QueueApp {

    public static void main(String[] args) {
        Queue theQueue = new Queue(5);
        theQueue.insert(5);
        theQueue.insert(29);
        theQueue.insert(34);
        theQueue.insert(43);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(32);
        theQueue.insert(43);
        theQueue.insert(32);
        theQueue.insert(23);

        while (!theQueue.isEmpty()){
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");


        }

        System.out.println("");

    }
}
