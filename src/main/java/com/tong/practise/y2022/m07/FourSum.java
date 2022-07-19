package com.tong.practise.y2022.m07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            long num1 = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long num2 = nums[j];
                int L = j + 1;
                int R = nums.length - 1;
                while (L < R) {
                    long num3 = nums[L];
                    long num4 = nums[R];
                    long tmp = num1 + num2 + num3 + num4;
                    if (tmp == target) {
                        List<Integer> datas = new ArrayList<>();
                        datas.add(nums[i]);
                        datas.add(nums[j]);
                        datas.add(nums[L]);
                        datas.add(nums[R]);
                        result.add(datas);
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        L++;
                        R--;
                    } else if (tmp < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        fourSum.fourSum(nums, target);

    }
}
