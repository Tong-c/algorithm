package com.tong.practise.y2023.binarysearch;

public class FindDuplicate2_287 {

    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count == mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindDuplicate2_287 tester = new FindDuplicate2_287();
        int[] nums = {1, 3, 4, 3, 2};
        System.out.println(tester.findDuplicate(nums));
    }
}
