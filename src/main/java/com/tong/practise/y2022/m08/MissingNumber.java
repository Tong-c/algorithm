package com.tong.practise.y2022.m08;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[n - 1] != n) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            int currNum = nums[i];
            if (currNum - nums[i - 1] > 1) {
                return currNum - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MissingNumber tester = new MissingNumber();
        int[] nums = {0, 1};
        System.out.println(tester.missingNumber(nums));
    }
}
