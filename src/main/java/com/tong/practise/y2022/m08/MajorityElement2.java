package com.tong.practise.y2022.m08;

public class MajorityElement2 {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        for (int i = 0; i <= length / 2; i++) {
            int currNum = nums[i];
            int count = 1;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == currNum) {
                    count++;
                } else {
                    count--;
                }
            }
            if (count >= 1) {
                return currNum;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement2 tester = new MajorityElement2();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(tester.majorityElement(nums));
    }
}
