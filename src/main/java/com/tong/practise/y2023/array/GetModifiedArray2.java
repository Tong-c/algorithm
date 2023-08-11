package com.tong.practise.y2023.array;

import java.util.Arrays;

public class GetModifiedArray2 {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        int[] diff = new int[length];
        diff[0] = nums[0];

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];

            diff[i] = diff[i] + val;
            if (j + 1 < length) {
                diff[j + 1] = diff[j + 1] - val;
            }
        }

        int[] res = new int[length];
        res[0] = diff[0];
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public static void main(String[] args) {
        GetModifiedArray2 getModifiedArray = new GetModifiedArray2();
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] modifiedArray = getModifiedArray.getModifiedArray(length, updates);
        System.out.println(Arrays.toString(modifiedArray));
    }
}
