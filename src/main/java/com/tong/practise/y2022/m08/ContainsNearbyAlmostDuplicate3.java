package com.tong.practise.y2022.m08;


import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (null == nums || nums.length <= 1) {
            return false;
        }
        int length = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            long currNum = nums[i];
            Long min = ts.floor(currNum);
            Long max = ts.ceiling(currNum);

            if (null != max && max - currNum <= t) {
                return true;
            }
            if (null != min && currNum - min <= t) {
                return true;
            }

            ts.add(currNum);

            if (i >= k) {
                ts.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate3 tester = new ContainsNearbyAlmostDuplicate3();
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        System.out.println(tester.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
