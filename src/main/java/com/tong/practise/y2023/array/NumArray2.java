package com.tong.practise.y2023.array;

public class NumArray2 {

    private int[] preSums;

    public NumArray2(int[] nums) {
        preSums = new int[nums.length + 1];
        preSums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSums[right] - preSums[left - 1];
    }
}
