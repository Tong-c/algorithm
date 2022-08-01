package com.tong.practise.y2022.m08;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate2 containsDuplicate = new ContainsNearbyDuplicate2();
        int[] nums = {1, 2, 3, 1};
        int k = 2;
        boolean duplicate = containsDuplicate.containsNearbyDuplicate(nums, k);
        System.out.println(duplicate);
    }
}
