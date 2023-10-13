package com.tong.practise.y2023.binarysearch;

public class FindDuplicate_287 {

    public int findDuplicate(int[] nums) {
        int size = nums.length;
        int result = doFind(nums, 0, size - 1);
        if (result >= 0) {
            return nums[result];
        }
        return -1;
    }

    private int doFind(int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return -1;
        }
        if (startIndex + 1 == endIndex) {
            if (nums[startIndex] == nums[endIndex]) {
                return startIndex;
            } else {
                return -1;
            }
        }

        int mid = startIndex + (endIndex - startIndex) / 2;
        int leftFindResult = doFind(nums, startIndex, mid);
        int rightFindResult = doFind(nums, mid + 1, endIndex);
        if (leftFindResult >= 0) {
            return leftFindResult;
        }
        if (rightFindResult >= 0) {
            return rightFindResult;
        }
        for (int i = startIndex; i <= mid; i++) {
            int leftNum = nums[i];
            for (int j = mid + 1; j <= endIndex; j++) {
                int rightNum = nums[j];
                if (leftNum == rightNum) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicate_287 tester = new FindDuplicate_287();
        int[] nums = {1, 3, 4, 3, 2};
        System.out.println(tester.findDuplicate(nums));
    }
}
