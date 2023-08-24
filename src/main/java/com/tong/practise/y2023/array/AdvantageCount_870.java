package com.tong.practise.y2023.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount_870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);

        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AdvantageCount_870 advantageCount = new AdvantageCount_870();
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        int[] result = advantageCount.advantageCount(nums1, nums2);
        System.out.println(result);
    }
}
