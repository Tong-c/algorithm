package com.tong.practise.y2023.binarysearch;

public class MySqrt {

    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if (mid * mid < x && (mid + 1) * (mid + 1) > x) {
                return mid;
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
        int x = 2;
        int result = mySqrt.mySqrt(x);
        System.out.println(result);
    }
}
