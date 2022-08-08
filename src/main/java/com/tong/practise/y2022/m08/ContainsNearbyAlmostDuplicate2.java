package com.tong.practise.y2022.m08;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate2 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (null == nums || nums.length <= 1) {
            return false;
        }

        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            Long l = ts.floor(u);
            Long r = ts.ceiling(u);

            if (l != null && u - l <= t) {
                return true;
            }
            if (r != null && r - u <= t) {
                return true;
            }

            ts.add(u);

            if (i >= k) {
                ts.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate2 tester = new ContainsNearbyAlmostDuplicate2();
        int[] nums = {2, 3, 1, 0};
        int k = 1;
        int t = 1;
        System.out.println(tester.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
