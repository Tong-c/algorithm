package com.tong.practise.y2022.m07;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public static int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length <= 1) {
            return new int[2];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (null != index) {
                return new int[]{i, index};
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{9, 7, 2, 11}, 9);
        System.out.println();
    }


}
