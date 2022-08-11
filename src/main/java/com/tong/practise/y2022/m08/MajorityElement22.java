package com.tong.practise.y2022.m08;

import java.util.*;

public class MajorityElement22 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> candidates = new HashMap<>();
        int k = 3;
        for (int num : nums) {
            if (candidates.size() < k - 1 || candidates.containsKey(num)) {
                candidates.put(num, candidates.getOrDefault(num, 0) + 1);
            } else {
                for (Iterator<Map.Entry<Integer, Integer>> it = candidates.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    if (entry.getValue() == 1) {
                        it.remove();
                    } else {
                        entry.setValue(entry.getValue() - 1);
                    }
                }
            }
        }

        for (int candidate : candidates.keySet()) {
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

    public static void main(String[] args) {
        MajorityElement22 tester = new MajorityElement22();
        int[] nums = {1};
        System.out.println(tester.majorityElement(nums));
    }
}
