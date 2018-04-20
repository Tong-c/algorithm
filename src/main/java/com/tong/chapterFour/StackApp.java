package com.tong.chapterFour;

public class StackApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);
        theStack.push(10);
        theStack.push(3);
        theStack.push(3);
        theStack.push(3);
        theStack.push(3);
        theStack.push(3);

        while (!theStack.isEmpty()){
            long value = theStack.pop();
            System.out.println(value);
            System.out.println(" ");
        }
    }
}
