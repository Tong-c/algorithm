package com.tong.practise.y2023.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intersection_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map2.get(num);
            if (count == null) {
                map2.put(num, 1);
            } else {
                map2.put(num, count + 1);
            }

            if (map.get(num) != null && map.get(num) > 0 && map2.get(num) != null && map2.get(num) == 1) {
                list.add(num);
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
        Intersection_349 tester = new Intersection_349();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersection = tester.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
