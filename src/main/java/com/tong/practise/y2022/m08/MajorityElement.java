package com.tong.practise.y2022.m08;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int currNum = nums[i];
            Integer countNum = countMap.get(currNum);
            countMap.put(currNum, countNum == null ? 1 : (countNum + 1));
            if (countMap.get(currNum) > length / 2) {
                return currNum;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement tester = new MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(tester.majorityElement(nums));
    }
}
