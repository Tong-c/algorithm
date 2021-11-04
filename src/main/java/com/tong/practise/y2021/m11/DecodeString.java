package com.tong.practise.y2021.m11;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            char prevC;
            if (isDigit(c)) {
                if (i > 0) {
                    prevC = chars[i - 1];
                    if (isDigit(prevC)) {
                        Integer pop = numStack.pop();
                        numStack.push(Integer.parseInt(pop + "" + c));
                    }else {
                        numStack.push(Integer.parseInt(c + ""));
                    }
                } else {
                    numStack.push(Integer.parseInt(c + ""));
                }
            } else {
                String currChar = String.valueOf(c);
                if (currChar.equals("]")) {
                    StringBuilder result = new StringBuilder();
                    Integer num = numStack.pop();
                    String popStr = getStr(strStack);
                    StringBuilder temp = new StringBuilder(generate(num, popStr));
                    temp.append(result);
                    result = temp;
                    strStack.push(result.toString());
                } else {
                    strStack.push(currChar);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for ( ; ; ) {
            if (strStack.isEmpty()) {
                break;
            }
            String pop = strStack.pop();
            if (null != pop && pop.toCharArray().length > 0) {
                StringBuilder temp = new StringBuilder(pop);
                temp.append(result);
                result = temp;
            } else {
                break;
            }
        }
        return result.toString();
    }

    private String generate(Integer num, String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(str);
        }
        return result.toString();
    }

    private String getStr(Stack<String> strStack) {
        StringBuilder result = new StringBuilder();
        for (; ; ) {
            String pop = strStack.pop();
            if (pop.equals("[")) {
                return result.toString();
            } else {
                StringBuilder temp = new StringBuilder(pop);
                temp.append(result);
                result = temp;
            }
        }
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("100[leetcode]"));
    }

}
