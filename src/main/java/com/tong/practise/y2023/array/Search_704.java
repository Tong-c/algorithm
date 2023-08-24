package com.tong.practise.y2023.array;

public class Search_704 {

    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_704 search_704 = new Search_704();
        int[] nums = {-1, 0, 3, 4, 5, 9, 12};
        int target = 5;
        // 4
        int result = search_704.search(nums, target);
        System.out.println(result);
    }
}
