package com.tong.lafore.chapterFour.stack;

public class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        CharStackX stack = new CharStackX(stackSize);
        for (int j = 0; j < stackSize; j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
                            System.out.println("Error:" + ch + "at " + j);
                        }
                    } else {
                        System.out.println("Error:" + ch + " at" + j);
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stack.isEmpty())
            System.out.println("Error:missing right delimeter");

    }
}
