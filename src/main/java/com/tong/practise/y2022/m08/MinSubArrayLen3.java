package com.tong.practise.y2022.m08;

/**
 * 长度最小的子数组
 */
public class MinSubArrayLen3 {

    public int minSubArrayLen(int target, int[] nums) {
        int lo = 0, hi = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum = sum + nums[hi];
            hi++;
            while (sum >= target) {
                if (hi - lo < min) {
                    min = hi - lo;
                }
                sum = sum - nums[lo];
                lo++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinSubArrayLen3 tester = new MinSubArrayLen3();
        int target = 10;
        int[] nums = {3, 4, 2, 8};
        System.out.println(tester.minSubArrayLen(target, nums));
    }
}
