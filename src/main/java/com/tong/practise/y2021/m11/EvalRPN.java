package com.tong.practise.y2021.m11;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvalRPN {
    List<String> operators = Arrays.asList("+", "-", "*", "/");
    List<String> brackets = Arrays.asList("(", ")");

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (!operators.contains(token) && !brackets.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else if (operators.contains(token)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(calc(num1, num2, token));
            }
        }
        return stack.pop();
    }

    private Integer calc(Integer num1, Integer num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
        }
        return null;
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] nums = {"4", "13", "5", "/", "+"};
        evalRPN.evalRPN(nums);
    }

}
