package com.tong.practise.y2022.m07;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length <= 1) {
            return new int[2];
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > target) {
                continue;
            }

            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[j] > target) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    if (i < j) {
                        return new int[]{i + 1, j + 1};
                    } else {
                        return new int[]{j + 1, i + 1};
                    }
                }
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{9, 7, 2, 11}, 9);
        System.out.println();
    }


}
