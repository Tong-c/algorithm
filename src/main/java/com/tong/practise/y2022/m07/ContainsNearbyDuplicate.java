package com.tong.practise.y2022.m07;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }

        for (int i = 0; i < len - 1; i++) {
            int inner = 0;
            if (k < len) {
                inner = (Math.min((i + k), (len - 1)));
            } else {
                inner = len - 1;
            }
            for (int j = i + 1; j <= inner; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsDuplicate = new ContainsNearbyDuplicate();
        int[] nums = {99, 99};
        int k = 2;
        boolean duplicate = containsDuplicate.containsNearbyDuplicate(nums, k);
        System.out.println(duplicate);
    }
}
