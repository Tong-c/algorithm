package com.tong.practise.y2022.m08;

public class MaxSubArray2 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxSubArray2 tester = new MaxSubArray2();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(tester.maxSubArray(nums));
    }

}
