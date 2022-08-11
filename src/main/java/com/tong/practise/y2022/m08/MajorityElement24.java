package com.tong.practise.y2022.m08;

import java.util.*;

public class MajorityElement24 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int k = 3;
        for (int i : nums) {
            if (countMap.size() < k - 1 || countMap.keySet().contains(i)) {
                countMap.put(i, countMap.getOrDefault(i, 0) + 1);
            } else {
                Iterator<Map.Entry<Integer, Integer>> iterator = countMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iterator.next();
                    Integer value = entry.getValue();
                    if (value - 1 <= 0) {
                        iterator.remove();
                    } else {
                        entry.setValue(value - 1);
                    }
                }
            }
        }

        for (int candidate : countMap.keySet()) {
            int count = 0;
            for (int num : nums) {
                if (num == candidate) {
                    count++;
                }
            }
            if (count > nums.length / k) {
                result.add(candidate);
            }
        }

        return result;
    }
}
