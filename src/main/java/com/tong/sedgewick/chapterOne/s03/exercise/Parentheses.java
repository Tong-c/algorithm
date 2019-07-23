package com.tong.sedgewick.chapterOne.s03.exercise;


import com.tong.sedgewick.chapterOne.s03.p94.Stack;

import java.util.Scanner;

public class Parentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(check(input));

    }

    public static boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);

            if (currChar == '{' || currChar == '[' || currChar == '(') {
                stack.push(currChar);
            }

            if (currChar == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

            if (currChar == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }

            if (currChar == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return true;
    }
}
