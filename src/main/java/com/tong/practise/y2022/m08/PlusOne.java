package com.tong.practise.y2022.m08;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        boolean flag = false;
        int[] result = new int[n + 2];
        int startIndex = 0;
        while (n >= 0) {
            int currNum = digits[n];
            if (n == digits.length - 1) {
                if (currNum + 1 >= 10) {
                    flag = true;
                    currNum = 0;
                } else {
                    currNum = currNum + 1;
                }
                result[startIndex] = currNum;
            } else {
                if (!flag) {
                    result[startIndex] = currNum;
                } else {
                    if (currNum + 1 >= 10) {
                        currNum = 0;
                    } else {
                        currNum = currNum + 1;
                        flag = false;
                    }
                    result[startIndex] = currNum;
                }
            }
            n--;
            startIndex++;
        }

        if (flag) {
            result[result.length - 1] = 1;
        }

        for (int i = 0; i < result.length / 2; i++) {
            int tmp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = tmp;
        }

        if (flag) {
            return result;
        } else {
            int[] tmp = new int[result.length - 1];
            for (int i = 1; i < result.length; i++) {
                tmp[i - 1] = result[i];
            }
            return tmp;
        }
    }

    public static void main(String[] args) {
        PlusOne tester = new PlusOne();
        int[] digits = {2, 3, 3};
        int[] result = tester.plusOne(digits);
        System.out.println(result);
    }
}
