package com.tong.practise.y2023.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindClosestElements_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (null == arr || arr.length == 0) {
            return result;
        }

        int l = 0;
        int r = arr.length - 1;
        int start = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                start = mid;
                break;
            }
            if (mid == 0 || mid == arr.length - 1) {
                start = mid;
                break;
            }
            if (arr[mid] < x) {
                l = mid + 1;
            } else if (arr[mid] > x) {
                r = mid - 1;
            }
        }
        result.add(arr[start]);

        l = start - 1;
        r = start + 1;
        while (l >= 0 && r <= arr.length - 1) {
            if (arr[start] - arr[l] < arr[r] - arr[start]) {
                result.add(arr[l]);
                l--;
            } else if (arr[start] - arr[l] > arr[r] - arr[start]) {
                result.add(arr[r]);
                r++;
            } else if (arr[start] - arr[l] == arr[r] - arr[start]) {
                result.add(arr[l]);
                l--;
            }
            if (result.size() == k) {
                break;
            }
        }

        if (r >= arr.length - 1 && result.size() < k) {
            while (l >= 0) {
                result.add(arr[l]);
                l--;
                if (result.size() == k) {
                    break;
                }
            }
        }

        // 最接近元素位于首端
        if (l <= 0 && result.size() < k) {
            while (r <= arr.length - 1) {
                result.add(arr[r]);
                r++;
                if (result.size() == k) {
                    break;
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        FindClosestElements_658 findClosestElements_658 = new FindClosestElements_658();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        // 1, 2, 3, 4
        List<Integer> result = findClosestElements_658.findClosestElements(arr, k, x);
        System.out.println(result);
    }
}
