package com.tong.lafore.chapterFour.stack;

public class Reverser {
    private String input;
    private String output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev(){
        int stackSize = input.length();
        CharStackX theStack = new CharStackX(stackSize);
        for(int j = 0; j< stackSize;j++){
            char ch = input.charAt(j);
            theStack.push(ch);
        }

        output = "";
        while (!theStack.isEmpty()){
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }
}
