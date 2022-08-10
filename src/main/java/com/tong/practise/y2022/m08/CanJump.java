package com.tong.practise.y2022.m08;

public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int k = 0;
        for (int i = 0; i <= k; i++) {
            int temp = i + nums[i];
            k = Math.max(k, temp);
            if (k >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump tester = new CanJump();
        int[] nums = {3, 2, 4};
        System.out.println(tester.canJump(nums));
    }
}
