package com.tong.practise.y2022.m08;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }

        int moveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum != 0) {
                nums[moveIndex] = currNum;
                moveIndex++;
            }
        }

        for (int i = moveIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes tester = new MoveZeroes();
        int[] nums = {0};
        tester.moveZeroes(nums);
        System.out.println("==========");
    }
}
