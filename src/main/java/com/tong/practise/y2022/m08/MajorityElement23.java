package com.tong.practise.y2022.m08;

import java.util.*;

public class MajorityElement23 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int m1 = nums[0];
        int m2 = 0;

        int c1 = 1;
        int c2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum == m1) {
                c1++;
            } else if (currNum == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = currNum;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = currNum;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m1 == nums[i]) {
                c1++;
            } else if (m2 == nums[i]) {
                c2++;
            }
        }

        if (c1 > nums.length / 3) {
            result.add(m1);
        }

        if (c2 > nums.length / 3) {
            result.add(m2);
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityElement23 tester = new MajorityElement23();
        int[] nums = {1};
        System.out.println(tester.majorityElement(nums));
    }
}
