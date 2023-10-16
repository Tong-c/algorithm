package com.tong.practise.y2023.binarysearch;

public class Divide_29 {

    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        boolean isNegative = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) {
            isNegative = true;
        }
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        long l = 0;
        long r = x;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (mul(mid, y) <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        long ans = isNegative ? -l : l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ans;
    }

    public long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans += a;
            }
            k >>= 1;
            a += a;
        }
        return ans;
    }

    public static void main(String[] args) {
        Divide_29 tester = new Divide_29();
        // 3，10-被除数，3-除数
        System.out.println(tester.mul(13, 10));
        /*long k = 5;
        System.out.println(k & 1);*/
    }
}
