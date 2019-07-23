package com.tong.lafore.chapterSix.noFactorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackTriangleApp {

    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    static int codePart;
    static Params theseParams;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        recTriangle();
    }

    private static void recTriangle() {
        theStack = new StackX(10000);
        codePart = 1;
        while (step() == false) {

        }
    }

    private static boolean step() {
        switch (codePart) {
            case 1:
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                break;
            case 2:
                theseParams = theStack.peek();
                if (theseParams.n == 1) {
                    theAnswer = 1;
                    codePart = 5;
                } else {
                    codePart = 3;
                }
                break;
            case 3:
                Params newParams = new Params(theseParams.n - 1, 4);
                theStack.push(newParams);
                codePart = 2;
                break;
            case 4:
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.n;
                codePart = 5;
                break;
            case 5:
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress;
                theStack.pop();
                break;
            case 6:
                return true;
        }
        return false;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }


    public static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String s = br.readLine();
        return s;
    }
}
