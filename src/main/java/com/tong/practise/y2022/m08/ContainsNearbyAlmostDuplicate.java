package com.tong.practise.y2022.m08;

public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (null == nums || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int innerLength = i + k;
            if (innerLength > nums.length - 1) {
                innerLength = nums.length - 1;
            }
            for (int j = i + 1; j <= innerLength; j++) {
                long numI = nums[i];
                long numJ = nums[j];
                if (Math.abs(numI - numJ) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate tester = new ContainsNearbyAlmostDuplicate();
        int[] nums = {-2147483648, 2147483647};
        int k = 1;
        int t = 1;
        System.out.println(tester.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
