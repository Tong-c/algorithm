package com.tong.lafore.chapterSix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//變位字
public class AnagramApp {

    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a word : ");
        String input = getString();
        size = input.length();
        count = 0;
        for (int j = 0; j < size; j++) {
            arrChar[j] = input.charAt(j);
        }
        doAnagram(size);
    }

    public static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String s = br.readLine();
        return s;
    }

    public static void doAnagram(int newsize) {
        if (newsize == 1) {
            return;
        }
        for (int j = 0; j < newsize; j++) {
            doAnagram(newsize - 1);
            if (newsize == 2) {
                displayWord();
            }
            rotate(newsize);
        }
    }

    public static void rotate(int newsize) {
        int j;
        int position = size - newsize;
        char temp = arrChar[position];
        for (j = position + 1; j < size; j++) {
            arrChar[j - 1] = arrChar[j];
        }
        arrChar[j - 1] = temp;
    }


    public static void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        }
        if (count < 9) {
            System.out.print(" ");
        }

        System.out.print(++count + " ");
        for (int j = 0; j < size; j++) {
            System.out.print(arrChar[j]);
        }

        System.out.print("  ");
        System.out.print(" ");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println("");
        }
    }
}
