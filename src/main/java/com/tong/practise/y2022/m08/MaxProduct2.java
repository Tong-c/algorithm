package com.tong.practise.y2022.m08;

public class MaxProduct2 {

    public int maxProduct(int[] nums) {
        int len = nums.length;

        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            } else {
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            }
        }

        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            if (dp[i][1] > res) {
                res = dp[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProduct2 tester = new MaxProduct2();
        int[] nums = {-3, -1, -1};
        System.out.println(tester.maxProduct(nums));
    }
}
