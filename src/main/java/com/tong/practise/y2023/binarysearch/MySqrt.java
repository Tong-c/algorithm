package com.tong.practise.y2023.binarysearch;

public class MySqrt {

    public int mySqrt(int x) {
        long l = 0;
        long r = x;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid < x && (mid + 1) * (mid + 1) > x) {
                return (int)mid;
            }
            if (mid * mid > x) {
                r = mid - 1;
            } else if (mid * mid < x) {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int x = 2147395599;
        int result = mySqrt.mySqrt(x);
        System.out.println(result);
    }
}
