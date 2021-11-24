package com.tong.practise.y2021.m11;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4};
        System.out.println(singleNumber(nums));
    }
}
