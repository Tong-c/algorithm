package com.tong.practise.y2022.m08;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            if (count == null) {
                countMap.put(nums[i], 1);
                nums[startIndex] = nums[i];
                startIndex++;
            } else {
                countMap.put(nums[i], count + 1);
            }
        }

        return countMap.size();
    }

    public static void main(String[] args) {
        RemoveDuplicates tester = new RemoveDuplicates();
        int[] nums = {2, 2, 4, 5, 6, 6};
        System.out.println(tester.removeDuplicates(nums));
    }
}
