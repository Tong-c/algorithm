package com.tong.practise.y2023.array;

public class SearchRange_34 {

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // 左侧边界
        int leftBound = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        if (left >= 0 && left < nums.length && nums[left] == target) {
            leftBound = left;
        }

        // 右侧边界
        int rightBound = -1;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right >= 0 && nums[right] == target) {
            rightBound = right;
        }
        return new int[]{leftBound, rightBound};
    }

    public static void main(String[] args) {
        SearchRange_34 searchRange_34 = new SearchRange_34();
        int[] nums = {2, 2};
        int target = 3;
        int[] result = searchRange_34.searchRange(nums, target);
        System.out.println(result);
    }
}
