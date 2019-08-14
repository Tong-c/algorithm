package com.tong.wangzheng.recursion;

import java.util.List;

/**
 * 递归
 */
public class Recursion {

    /**
     * 斐波那契
     */
    public static int fibonacci(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    /**
     * 阶乘
     */
    public static int factorial(int num) {
        if (num == 1) return 1;
        return num * factorial(num - 1);
    }

    /**
     * 全排列
     */
    public static List<List<Integer>> permute() {
        return null;
    }


    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println(factorial(6));
    }
}
