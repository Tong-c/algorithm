package com.tong.practise.y2023.binarysearch;

public class MyPow_50 {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }


    double quickMul(double x, long N) {
        if (N == 0) return 1.0;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    // x的n次方
    public static void main(String[] args) {
        MyPow_50 myPow = new MyPow_50();
        System.out.println(myPow.myPow(2, -8));
    }
}
