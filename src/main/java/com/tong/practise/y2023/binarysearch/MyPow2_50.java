package com.tong.practise.y2023.binarysearch;

public class MyPow2_50 {

    public double myPow(double x, int n) {
        double result = quickMul(x, n);
        return n < 0 ? 1 / result : result;
    }

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    // x的n次方
    public static void main(String[] args) {
        MyPow2_50 myPow = new MyPow2_50();
        System.out.println(myPow.myPow(2, -8));
    }
}
