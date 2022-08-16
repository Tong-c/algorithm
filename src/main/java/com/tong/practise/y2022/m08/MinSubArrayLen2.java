package com.tong.practise.y2022.m08;

public class MinSubArrayLen2 {

    public int minSubArrayLen(int target, int[] nums) {
        int lo = 0;
        int hi = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi];
            hi++;
            while (sum >= target) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo];
                lo++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinSubArrayLen2 tester = new MinSubArrayLen2();
        int target = 10;
        int[] nums = {3, 4, 2, 8};
        System.out.println(tester.minSubArrayLen(target, nums));
    }
}
