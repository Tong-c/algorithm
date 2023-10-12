package com.tong.practise.y2023.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intersect_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count > 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }

        int[] result = new int[list.size()];
        int startIndex = 0;
        for (Integer num : list) {
            result[startIndex++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Intersect_350 tester = new Intersect_350();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = tester.intersect(nums1, nums2);
        // 2, 2
        System.out.println(Arrays.toString(result));
    }
}
