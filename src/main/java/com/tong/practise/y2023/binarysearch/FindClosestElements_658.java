package com.tong.practise.y2023.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindClosestElements_658 findClosestElements_658 = new FindClosestElements_658();
        int[] arr = {1, 1, 1, 2, 10, 10, 10};
        int k = 1;
        int x = 11;
        // 1, 2, 3, 4
        List<Integer> result = findClosestElements_658.findClosestElements(arr, k, x);
        System.out.println(result);
    }
}
