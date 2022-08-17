package com.tong.practise.y2022.m08;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (null == nums) {
            return;
        }

        int len = nums.length;
        if (len <= 1) {
            return;
        }

        boolean changeFlag = false;
        int changeIndex = -1;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int lessNumIndex = findLessNumIndex(nums, len, i);
                if (lessNumIndex != -1) {
                    change(nums, i - 1, lessNumIndex);
                    changeFlag = true;
                    changeIndex = i - 1;
                    break;
                }
            }
        }

        if (changeFlag) {
            sort(nums, changeIndex + 1);
        } else {
            Arrays.sort(nums);
        }
    }

    private int findLessNumIndex(int[] nums, int len, int startIndex) {
        for (int j = len - 1; j >= startIndex; j--) {
            if (nums[j] > nums[startIndex - 1]) {
                return j;
            }
        }
        return -1;
    }

    private void change(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }


    public void sort(int[] nums, int index){
        int[] newArray = new int[nums.length - index];

        int j = 0;
        for (int i = index; i < nums.length; i++) {
            newArray[j++] = nums[i];
        }

        Arrays.sort(newArray);

        int k = 0;
        for (int i = index; i < nums.length; i++) {
            nums[i] = newArray[k++];
        }
    }

    public static void main(String[] args) {
        NextPermutation tester = new NextPermutation();
        int[] nums = {8, 5, 3, 2};
        // 2, 3, 5, 8
        // 2, 3, 8, 5
        // 2, 5, 3, 8
        // 2, 5, 8, 3
        // 2, 8, 3, 5
        // 2, 8, 5, 3
        tester.nextPermutation(nums);
        System.out.println("==========");
    }
}
