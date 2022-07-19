package com.tong.practise.y2022.m07;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int tmp = currNum + nums[L] + nums[R];
                int curDiff = calcDiff(tmp, target);
                if (curDiff < diff) {
                    result = tmp;
                    diff = curDiff;
                }
                if (tmp > target) {
                    R--;
                } else if (tmp < target) {
                    L++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    private static int calcDiff(int num1, int num2) {
        int diff = num1 - num2;
        if (diff < 0) {
            return -diff;
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums = {-763,567,885,-628,-530,-468,549,-341,275,-282,22,-448,-804,-369,636,-677,-907,898,8,-643,213,245,756,-328,-987,-433,639,-18,-104,-439,715,-145,-703,299,-84,767,818,-300,-374,232,962,-289,638,144,-508,870,480,-70,-576,661,-808};
        int target = -2145;
        System.out.println(threeSumClosest(nums, target));
    }
}
