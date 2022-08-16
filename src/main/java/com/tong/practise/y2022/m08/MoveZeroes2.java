package com.tong.practise.y2022.m08;

public class MoveZeroes2 {

    public void moveZeroes(int[] nums) {
        if (null == nums) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes2 tester = new MoveZeroes2();
        int[] nums = {0, 1, 3, 0, 12};
        tester.moveZeroes(nums);
        System.out.println("==========");
    }
}
