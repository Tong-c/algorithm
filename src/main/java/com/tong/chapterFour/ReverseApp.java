package com.tong.chapterFour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {
    public static void main(String[] args) {
        String input,output;
        while (true){
            System.out.println("Enter a string : ");
            System.out.flush();
            input = getString();
            if(input.equals("")){
                break;
            }

            Reverser reverser = new Reverser(input);
            output = reverser.doRev();
            System.out.println("Reversed:" + output);

        }
    }


    public static String getString(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        try {
            String s = br.readLine();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
