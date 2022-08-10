package com.tong.practise.y2022.m08;

public class FindMin {

    public int findMin(int[] nums) {
        int length = nums.length;
        int leftPtr = 0;
        int rightPtr = length - 1;
        while (leftPtr + 1 < rightPtr) {
            int midPtr = leftPtr + (rightPtr - leftPtr) / 2;

            if (nums[leftPtr] > nums[midPtr]) {
                rightPtr = midPtr;
            }

            if (nums[midPtr] > nums[rightPtr]) {
                leftPtr = midPtr;
            }

            if (nums[leftPtr] < nums[midPtr] && nums[midPtr] < nums[rightPtr]) {
                return nums[0];
            }
        }
        return Math.min(nums[leftPtr], nums[rightPtr]);
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums = {11, 13, 15, 17};
        System.out.println(findMin.findMin(nums));
    }
}
