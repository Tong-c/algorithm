package com.tong.lafore.chapterEight;

public class Node {

    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print(" { ");
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.println(" }");
    }


}
