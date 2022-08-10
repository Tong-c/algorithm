package com.tong.practise.y2022.m08;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int leftPtr = 0;
        int rightPtr = length - 1;
        while (leftPtr < rightPtr) {
            int midPtr = leftPtr + (rightPtr - leftPtr) / 2;

            if (nums[midPtr] > nums[midPtr + 1]) {
                rightPtr = midPtr;
            } else {
                leftPtr = midPtr + 1;
            }
        }
        return leftPtr;
    }

    public static void main(String[] args) {
        FindPeakElement tester = new FindPeakElement();
        int[] nums = {1, 1, 2, 3, 1, 4};
        System.out.println(tester.findPeakElement(nums));
    }
}
