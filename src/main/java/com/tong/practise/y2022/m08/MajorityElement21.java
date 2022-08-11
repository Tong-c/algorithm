package com.tong.practise.y2022.m08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement21 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int currNum = nums[i];
            Integer countVal = countMap.get(currNum);
            if (null == countVal) {
                countMap.put(currNum, 1);
            } else {
                if (countVal > length / 3) {
                    continue;
                }
                countMap.put(currNum, countVal + 1);
            }

            if (countMap.get(currNum) > length / 3) {
                if (!result.contains(currNum)) {
                    result.add(currNum);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityElement21 tester = new MajorityElement21();
        int[] nums = {1};
        System.out.println(tester.majorityElement(nums));
    }
}
