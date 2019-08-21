package com.tong.wangzheng.recursion;


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
    public static void permute(char[] data, int start, int end) {
        if (end <= 1) {
            return;
        }
        if (start == end) {
            System.out.println(data);
        } else {
            for (int i = start; i <= end; i++) {
                swap(data, i, start);
                permute(data, start + 1, end);
                swap(data, start, i);
            }
        }
    }


    private static void swap(char[] data, int i, int j) {
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    public static void main(String[] args) {
//        System.out.println(fibonacci(6));
//        System.out.println(factorial(6));
        char[] data = {'2', '3', '4', '5', '6', '7'};
        permute(data, 0, 5);
    }
}
