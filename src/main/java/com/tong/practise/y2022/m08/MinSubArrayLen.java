package com.tong.practise.y2022.m08;

/**
 * 长度最小的子数组
 */
public class MinSubArrayLen {

    /**
     * 超出时间限制
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int targetNum = target - currNum;
            if (targetNum <= 0) {
                return 1;
            } else {
                int sum = 0;
                int count = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    count++;
                    sum = sum + nums[j];
                    if (sum >= targetNum) {
                        int currLen = count + 1;
                        if (minLen == 0) {
                            minLen = currLen;
                        } else {
                            if (minLen > currLen) {
                                minLen = currLen;
                            }
                        }
                    }
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        MinSubArrayLen tester = new MinSubArrayLen();
        int target = 10;
        int[] nums = {3, 4, 2, 8};
        System.out.println(tester.minSubArrayLen(target, nums));
    }
}
