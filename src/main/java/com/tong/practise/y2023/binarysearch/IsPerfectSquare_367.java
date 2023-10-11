package com.tong.practise.y2023.binarysearch;

public class IsPerfectSquare_367 {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num / 2 + 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle * middle == num) {
                return true;
            } else if (middle * middle > num) {
                right = middle - 1;
            } else if (middle * middle < num) {
                left = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare_367 isPerfectSquare = new IsPerfectSquare_367();
        System.out.println(isPerfectSquare.isPerfectSquare(9));
    }
}
