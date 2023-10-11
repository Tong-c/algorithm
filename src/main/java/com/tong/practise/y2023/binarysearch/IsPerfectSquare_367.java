package com.tong.practise.y2023.binarysearch;

public class IsPerfectSquare_367 {

    public boolean isPerfectSquare(int num) {
        for (int i = 0; i < num / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare_367 isPerfectSquare = new IsPerfectSquare_367();
        System.out.println(isPerfectSquare.isPerfectSquare(16));
    }
}
