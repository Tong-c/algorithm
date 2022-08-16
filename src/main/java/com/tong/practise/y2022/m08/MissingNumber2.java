package com.tong.practise.y2022.m08;

public class MissingNumber2 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        MissingNumber2 tester = new MissingNumber2();
        int[] nums = {0, 1, 2, 4};
        System.out.println(tester.missingNumber(nums));
    }
}
